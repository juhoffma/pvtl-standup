package io.pivotal.slack.bot.pvtlstandup.blocks;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "image_url",
        "alt_text"
})
public class Accessory {

    @JsonProperty("type")
    private String type;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("alt_text")
    private String altText;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Accessory() {
    }

    /**
     * @param imageUrl
     * @param altText
     * @param type
     */
    public Accessory(String type, String imageUrl, String altText) {
        super();
        this.type = type;
        this.imageUrl = imageUrl;
        this.altText = altText;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Accessory withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Accessory withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @JsonProperty("alt_text")
    public String getAltText() {
        return altText;
    }

    @JsonProperty("alt_text")
    public void setAltText(String altText) {
        this.altText = altText;
    }

    public Accessory withAltText(String altText) {
        this.altText = altText;
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

    public Accessory withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).append("imageUrl", imageUrl).append("altText", altText).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(imageUrl).append(additionalProperties).append(altText).append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Accessory) == false) {
            return false;
        }
        Accessory rhs = ((Accessory) other);
        return new EqualsBuilder().append(imageUrl, rhs.imageUrl).append(additionalProperties, rhs.additionalProperties).append(altText, rhs.altText).append(type, rhs.type).isEquals();
    }

}
