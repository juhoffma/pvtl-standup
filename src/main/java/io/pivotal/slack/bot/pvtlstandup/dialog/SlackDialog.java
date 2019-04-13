package io.pivotal.slack.bot.pvtlstandup.dialog;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "trigger_id",
        "dialog"
})
public class SlackDialog {

    @JsonProperty("trigger_id")
    private String triggerId;
    @JsonProperty("dialog")
    private Dialog dialog;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public SlackDialog() {
    }

    /**
     *
     * @param triggerId
     * @param dialog
     */
    public SlackDialog(String triggerId, Dialog dialog) {
        super();
        this.triggerId = triggerId;
        this.dialog = dialog;
    }

    @JsonProperty("trigger_id")
    public String getTriggerId() {
        return triggerId;
    }

    @JsonProperty("trigger_id")
    public void setTriggerId(String triggerId) {
        this.triggerId = triggerId;
    }

    public SlackDialog withTriggerId(String triggerId) {
        this.triggerId = triggerId;
        return this;
    }

    @JsonProperty("dialog")
    public Dialog getDialog() {
        return dialog;
    }

    @JsonProperty("dialog")
    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public SlackDialog withDialog(Dialog dialog) {
        this.dialog = dialog;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public SlackDialog withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("triggerId", triggerId).append("dialog", dialog).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(triggerId).append(dialog).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SlackDialog) == false) {
            return false;
        }
        SlackDialog rhs = ((SlackDialog) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(triggerId, rhs.triggerId).append(dialog, rhs.dialog).isEquals();
    }

}