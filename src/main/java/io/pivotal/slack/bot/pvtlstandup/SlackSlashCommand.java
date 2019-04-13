package io.pivotal.slack.bot.pvtlstandup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.pivotal.slack.bot.pvtlstandup.dialog.*;
import me.ramswaroop.jbot.core.slack.models.Attachment;
import me.ramswaroop.jbot.core.slack.models.RichMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.singletonList;

/**
 * Sample Slash Command Handler.
 *
 * @author ramswaroop
 * @version 1.0.0, 20/06/2016
 */
@RestController
@Profile("slack")
public class SlackSlashCommand {

    private static final Logger logger = LoggerFactory.getLogger(SlackSlashCommand.class);

    /**
     * The token you get while creating a new Slash Command. You
     * should paste the token in application.properties file.
     */
    @Value("${slashCommandToken}")
    private String slashCommandToken;

    /**
     * Slack token from application.properties file. You can get your slack token
     * next <a href="https://my.slack.com/services/new/bot">creating a new bot</a>.
     */
    @Value("${slackBotToken}")
    private String slackBotToken;

    @Value("${slackApi}")
    private String slackApi;


    /**
     * Slash Command handler. When a user types for example "/app help"
     * then slack sends a POST request to this endpoint. So, this endpoint
     * should match the url you set while creating the Slack Slash Command.
     *
     * @param token
     * @param teamId
     * @param teamDomain
     * @param channelId
     * @param channelName
     * @param userId
     * @param userName
     * @param command
     * @param text
     * @param responseUrl
     * @return
     */
    @RequestMapping(value = "/slash-command",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RichMessage onReceiveSlashCommand(@RequestParam("token") String token,
                                             @RequestParam("team_id") String teamId,
                                             @RequestParam("team_domain") String teamDomain,
                                             @RequestParam("channel_id") String channelId,
                                             @RequestParam("channel_name") String channelName,
                                             @RequestParam("user_id") String userId,
                                             @RequestParam("user_name") String userName,
                                             @RequestParam("command") String command,
                                             @RequestParam("text") String text,
                                             @RequestParam("trigger_id") String triggerId,
                                             @RequestParam("response_url") String responseUrl) {
        // validate token
        if (!token.equals(slashCommandToken)) {
            return new RichMessage("Sorry! You're not lucky enough to use our slack command.");
        }

        /* build response */
        RichMessage richMessage = new RichMessage("The is Slash Commander!");
        richMessage.setResponseType("in_channel");
        // set attachments
        Attachment[] attachments = new Attachment[12];
        attachments[0] = new Attachment();
        attachments[0].setText("I will perform all tasks for you.");

        attachments[1] = new Attachment();
        attachments[1].setText("token: " + token);

        attachments[2] = new Attachment();
        attachments[2].setText("team_id: " + teamId);

        attachments[3] = new Attachment();
        attachments[3].setText("team_domain: " + teamDomain);

        attachments[4] = new Attachment();
        attachments[4].setText("channel_id: " + channelId);

        attachments[5] = new Attachment();
        attachments[5].setText("channel_name: " + channelName);

        attachments[6] = new Attachment();
        attachments[6].setText("user_id: " + userId);

        attachments[7] = new Attachment();
        attachments[7].setText("user_name: " + userName);

        attachments[8] = new Attachment();
        attachments[8].setText("command: " + command);

        attachments[9] = new Attachment();
        attachments[9].setText("text: " + text);

        attachments[10] = new Attachment();
        attachments[10].setText("response_url: " + responseUrl);

        attachments[11] = new Attachment();
        attachments[11].setText("trigger_id: " + triggerId);

        richMessage.setAttachments(attachments);

        // For debugging purpose only
        if (logger.isDebugEnabled()) {
            try {
                logger.debug("Reply (RichMessage): {}", new ObjectMapper().writeValueAsString(richMessage));
            } catch (JsonProcessingException e) {
                logger.debug("Error parsing RichMessage: ", e);
            }
        }

        return richMessage.encodedMessage(); // don't forget to send the encoded message to Slack
    }


    /**
     * Slash Command handler. When a user types for example "/app help"
     * then slack sends a POST request to this endpoint. So, this endpoint
     * should match the url you set while creating the Slack Slash Command.
     *
     * @param token
     * @param teamId
     * @param teamDomain
     * @param channelId
     * @param channelName
     * @param userId
     * @param userName
     * @param command
     * @param text
     * @param responseUrl
     * @return
     */
    @RequestMapping(value = "/weekly-dialog",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String onReceiveWeeklyDialog(@RequestParam("token") String token,
                                        @RequestParam("team_id") String teamId,
                                        @RequestParam("team_domain") String teamDomain,
                                        @RequestParam("channel_id") String channelId,
                                        @RequestParam("channel_name") String channelName,
                                        @RequestParam("user_id") String userId,
                                        @RequestParam("user_name") String userName,
                                        @RequestParam("command") String command,
                                        @RequestParam("text") String text,
                                        @RequestParam("trigger_id") String triggerId,
                                        @RequestParam("response_url") String responseUrl) {
        // validate token
        if (!token.equals(slashCommandToken)) {
            return null;
        }


        Element customer = new Element()
                .withLabel("Customer")
                .withName("customer")
                .withType("text")
                .withAdditionalProperty("placeholder", "You can also use the shortname");

        Element partner = new Element()
                .withLabel("Partner")
                .withName("partner")
                .withAdditionalProperty("optional", "true")
                .withType("text");

        Element description = new Element()
                .withLabel("Description")
                .withName("description")
                .withType("textarea")
                .withValue(text)
                .withAdditionalProperty("hint", "Provide additional information about what you have done");

        /*
          Accounts with POSITIVE activity this week
          Accounts with NEGATIVE activity this week
          Accounts stayed FLAT this week(only if any activity happened)
          POC Focus Notes (ALL POCs)
          General Management updates this week (Hashtag with #Issue for issues)
          Competitive Trends/Updates (if any)
          Product Trends/Updates (if any)
          Other Noteworthy items  (if any)
         */
        OptionGroup impacts = new OptionGroup()
                .withLabel("Customer Impact and PoC")
                .withOptions(Arrays.asList(
                        new Option()
                                .withLabel("Positive")
                                .withValue("positive"),
                        new Option()
                                .withLabel("Negative")
                                .withValue("negative"),
                        new Option()
                                .withLabel("Flat")
                                .withValue("flat"),
                        new Option()
                                .withLabel("PoC/PoV Update")
                                .withValue("poc")
                ));

        OptionGroup management = new OptionGroup()
                .withLabel("General Management Updates")
                .withOptions(singletonList(
                        new Option()
                                .withLabel("Management Attention")
                                .withValue("attention")
                ));

        OptionGroup other = new OptionGroup()
                .withLabel("Other Updates")
                .withOptions(Arrays.asList(
                        new Option()
                                .withLabel("Competitive Trends/Updates")
                                .withValue("competitive"),
                        new Option()
                                .withLabel("Product Trends/Updates")
                                .withValue("product"),
                        new Option()
                                .withLabel("Other Noteworthy Items")
                                .withValue("other")
                ));

        Element impact = new Element()
                .withType("select")
                .withLabel("Customer Outcomes")
                .withName("outcome")
                .withValue("positive")
                .withOptionGroups(Arrays.asList(impacts, management, other));

        Element notify = new Element()
                .withType("select")
                .withLabel("Post this Message also on")
                .withName("channel_notify")
                .withAdditionalProperty("data_source", "conversations");

        Dialog dialog = new Dialog()
                .withElements(Arrays.asList(customer, impact, partner, description, notify))
                .withTitle("Weekly Entry")
                .withSubmitLabel("Save")
                .withNotifyOnCancel(true)
                .withCallbackId("lookout")
                .withState("state");

        SlackDialog weeklyDialog = new SlackDialog()
                .withDialog(dialog)
                .withTriggerId(triggerId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + slackBotToken);
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> request = null;
        try {
            ObjectMapper jacksonMapper = new ObjectMapper();
            jacksonMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

            String jsonString = jacksonMapper.writeValueAsString(weeklyDialog);
            request = new HttpEntity<>(jsonString, headers);
            logger.debug(jsonString);
        } catch (JsonProcessingException e) {
            logger.debug("Error parsing WeeklyDialog: ", e);
        }

        String response = restTemplate.postForObject("https://pivotal.slack.com/api/dialog.open", request, String.class);

        return null;
    }

    @RequestMapping(value = "/dialog-response",
            method = RequestMethod.POST)
    public String onReceiveDialogResponse(@RequestParam("payload") String encodedJson) {

        logger.debug("Starting processing of a DialogResponse");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        Map<String, Object> jsonMap = null;
        try {
            jsonMap = objectMapper.readValue(encodedJson,
                    new TypeReference<Map<String, Object>>() {
                    });

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + slackBotToken);
            RestTemplate restTemplate = new RestTemplate();
            Map<String, String> response = new HashMap<>();

            Map<String, String> channel = (Map<String, String>) jsonMap.get("channel");
            Map<String, String> submission = (Map<String, String>) jsonMap.get("submission");

            response.put("token", slackBotToken);
            response.put("channel", channel.get("id"));
            response.put("text", "Thank you for your addition to the weekly");
            response.put("reply_broadcast", "false");

            logger.debug("Replying (payload): {} to channel_id {}", objectMapper.writeValueAsString(response), response.get("channel"));
            HttpEntity<String> request = new HttpEntity<>(objectMapper.writeValueAsString(response), headers);

            String theResponse = restTemplate.postForObject(slackApi + "/chat.postMessage", request, String.class);
            logger.debug("Got this message back {}", theResponse);

            response.put("channel", submission.get("channel_notify"));

            logger.debug("Replying (payload): {} to channel_id {}", objectMapper.writeValueAsString(response), response.get("channel"));
            request = new HttpEntity<>(objectMapper.writeValueAsString(response), headers);

            theResponse = restTemplate.postForObject(slackApi + "/chat.postMessage", request, String.class);
            logger.debug("Got this message back {}", theResponse);

        } catch (IOException e) {
            logger.debug("Error parsing RequestParams: ", e);
        }

        return "";
    }

}
