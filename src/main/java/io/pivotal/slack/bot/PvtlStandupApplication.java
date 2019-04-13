package io.pivotal.slack.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot", "io.pivotal.slack.bot.pvtlstandup"})
public class PvtlStandupApplication {

    public static void main(String[] args) {
        SpringApplication.run(PvtlStandupApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
