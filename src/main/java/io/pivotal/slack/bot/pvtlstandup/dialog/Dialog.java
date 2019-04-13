package io.pivotal.slack.bot.pvtlstandup.dialog;

import java.util.HashMap;
import java.util.List;
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
        "callback_id",
        "title",
        "submit_label",
        "notify_on_cancel",
        "state",
        "elements"
})
public class Dialog {

    @JsonProperty("callback_id")
    private String callbackId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("submit_label")
    private String submitLabel;
    @JsonProperty("notify_on_cancel")
    private Boolean notifyOnCancel;
    @JsonProperty("state")
    private String state;
    @JsonProperty("elements")
    private List<Element> elements = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Dialog() {
    }

    /**
     *
     * @param title
     * @param callbackId
     * @param state
     * @param submitLabel
     * @param notifyOnCancel
     * @param elements
     */
    public Dialog(String callbackId, String title, String submitLabel, Boolean notifyOnCancel, String state, List<Element> elements) {
        super();
        this.callbackId = callbackId;
        this.title = title;
        this.submitLabel = submitLabel;
        this.notifyOnCancel = notifyOnCancel;
        this.state = state;
        this.elements = elements;
    }

    @JsonProperty("callback_id")
    public String getCallbackId() {
        return callbackId;
    }

    @JsonProperty("callback_id")
    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }

    public Dialog withCallbackId(String callbackId) {
        this.callbackId = callbackId;
        return this;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Dialog withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("submit_label")
    public String getSubmitLabel() {
        return submitLabel;
    }

    @JsonProperty("submit_label")
    public void setSubmitLabel(String submitLabel) {
        this.submitLabel = submitLabel;
    }

    public Dialog withSubmitLabel(String submitLabel) {
        this.submitLabel = submitLabel;
        return this;
    }

    @JsonProperty("notify_on_cancel")
    public Boolean getNotifyOnCancel() {
        return notifyOnCancel;
    }

    @JsonProperty("notify_on_cancel")
    public void setNotifyOnCancel(Boolean notifyOnCancel) {
        this.notifyOnCancel = notifyOnCancel;
    }

    public Dialog withNotifyOnCancel(Boolean notifyOnCancel) {
        this.notifyOnCancel = notifyOnCancel;
        return this;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    public Dialog withState(String state) {
        this.state = state;
        return this;
    }

    @JsonProperty("elements")
    public List<Element> getElements() {
        return elements;
    }

    @JsonProperty("elements")
    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public Dialog withElements(List<Element> elements) {
        this.elements = elements;
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

    public Dialog withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("callbackId", callbackId).append("title", title).append("submitLabel", submitLabel).append("notifyOnCancel", notifyOnCancel).append("state", state).append("elements", elements).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(title).append(additionalProperties).append(callbackId).append(state).append(submitLabel).append(notifyOnCancel).append(elements).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Dialog) == false) {
            return false;
        }
        Dialog rhs = ((Dialog) other);
        return new EqualsBuilder().append(title, rhs.title).append(additionalProperties, rhs.additionalProperties).append(callbackId, rhs.callbackId).append(state, rhs.state).append(submitLabel, rhs.submitLabel).append(notifyOnCancel, rhs.notifyOnCancel).append(elements, rhs.elements).isEquals();
    }

}