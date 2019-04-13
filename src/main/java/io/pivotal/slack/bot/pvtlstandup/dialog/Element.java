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
        "type",
        "label",
        "name",
        "options",
        "option_groups",
        "hint",
        "placeholder",
        "max_length",
        "min_length",
        "optional",
        "value"
})
public class Element {

    @JsonProperty("type")
    private String type;
    @JsonProperty("label")
    private String label;
    @JsonProperty("name")
    private String name;
    @JsonProperty("options")
    private List<Option> options = null;
    @JsonProperty("option_groups")
    private List<OptionGroup> optionGroups = null;
    @JsonProperty("hint")
    private String hint;
    @JsonProperty("placeholder")
    private String placeholder;
    @JsonProperty("max_length")
    private Integer maxLength;
    @JsonProperty("min_length")
    private Integer minLength;
    @JsonProperty("optional")
    private Boolean optional;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Element() {
    }

    /**
     *
     * @param maxLength
     * @param minLength
     * @param placeholder
     * @param optionGroups
     * @param optional
     * @param name
     * @param value
     * @param hint
     * @param label
     * @param type
     * @param options
     */
    public Element(String type, String label, String name, List<Option> options, List<OptionGroup> optionGroups, String hint, String placeholder, Integer maxLength, Integer minLength, Boolean optional, String value) {
        super();
        this.type = type;
        this.label = label;
        this.name = name;
        this.options = options;
        this.optionGroups = optionGroups;
        this.hint = hint;
        this.placeholder = placeholder;
        this.maxLength = maxLength;
        this.minLength = minLength;
        this.optional = optional;
        this.value = value;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Element withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    public Element withLabel(String label) {
        this.label = label;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Element withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("options")
    public List<Option> getOptions() {
        return options;
    }

    @JsonProperty("options")
    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Element withOptions(List<Option> options) {
        this.options = options;
        return this;
    }

    @JsonProperty("option_groups")
    public List<OptionGroup> getOptionGroups() {
        return optionGroups;
    }

    @JsonProperty("option_groups")
    public void setOptionGroups(List<OptionGroup> optionGroups) {
        this.optionGroups = optionGroups;
    }

    public Element withOptionGroups(List<OptionGroup> optionGroups) {
        this.optionGroups = optionGroups;
        return this;
    }

    @JsonProperty("hint")
    public String getHint() {
        return hint;
    }

    @JsonProperty("hint")
    public void setHint(String hint) {
        this.hint = hint;
    }

    public Element withHint(String hint) {
        this.hint = hint;
        return this;
    }

    @JsonProperty("placeholder")
    public String getPlaceholder() {
        return placeholder;
    }

    @JsonProperty("placeholder")
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public Element withPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    @JsonProperty("max_length")
    public Integer getMaxLength() {
        return maxLength;
    }

    @JsonProperty("max_length")
    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Element withMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    @JsonProperty("min_length")
    public Integer getMinLength() {
        return minLength;
    }

    @JsonProperty("min_length")
    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Element withMinLength(Integer minLength) {
        this.minLength = minLength;
        return this;
    }

    @JsonProperty("optional")
    public Boolean getOptional() {
        return optional;
    }

    @JsonProperty("optional")
    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    public Element withOptional(Boolean optional) {
        this.optional = optional;
        return this;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    public Element withValue(String value) {
        this.value = value;
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

    public Element withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).append("label", label).append("name", name).append("options", options).append("optionGroups", optionGroups).append("hint", hint).append("placeholder", placeholder).append("maxLength", maxLength).append("minLength", minLength).append("optional", optional).append("value", value).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(placeholder).append(hint).append(label).append(type).append(maxLength).append(additionalProperties).append(minLength).append(optionGroups).append(optional).append(name).append(value).append(options).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Element) == false) {
            return false;
        }
        Element rhs = ((Element) other);
        return new EqualsBuilder().append(placeholder, rhs.placeholder).append(hint, rhs.hint).append(label, rhs.label).append(type, rhs.type).append(maxLength, rhs.maxLength).append(additionalProperties, rhs.additionalProperties).append(minLength, rhs.minLength).append(optionGroups, rhs.optionGroups).append(optional, rhs.optional).append(name, rhs.name).append(value, rhs.value).append(options, rhs.options).isEquals();
    }

}