package io.pivotal.slack.bot.pvtlstandup.blocks;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "text",
        "block_id",
        "accessory",
        "fields"
})
public class Block {

    @JsonProperty("type")
    private String type;
    @JsonProperty("text")
    private Text text;
    @JsonProperty("block_id")
    private String blockId;
    @JsonProperty("accessory")
    private Accessory accessory;
    @JsonProperty("fields")
    private List<Field> fields = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Block() {
    }

    /**
     * @param text
     * @param accessory
     * @param blockId
     * @param type
     * @param fields
     */
    public Block(String type, Text text, String blockId, Accessory accessory, List<Field> fields) {
        super();
        this.type = type;
        this.text = text;
        this.blockId = blockId;
        this.accessory = accessory;
        this.fields = fields;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Block withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("text")
    public Text getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(Text text) {
        this.text = text;
    }

    public Block withText(Text text) {
        this.text = text;
        return this;
    }

    @JsonProperty("block_id")
    public String getBlockId() {
        return blockId;
    }

    @JsonProperty("block_id")
    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public Block withBlockId(String blockId) {
        this.blockId = blockId;
        return this;
    }

    @JsonProperty("accessory")
    public Accessory getAccessory() {
        return accessory;
    }

    @JsonProperty("accessory")
    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }

    public Block withAccessory(Accessory accessory) {
        this.accessory = accessory;
        return this;
    }

    @JsonProperty("fields")
    public List<Field> getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public Block withFields(List<Field> fields) {
        this.fields = fields;
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

    public Block withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).append("text", text).append("blockId", blockId).append("accessory", accessory).append("fields", fields).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(text).append(accessory).append(blockId).append(additionalProperties).append(type).append(fields).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Block) == false) {
            return false;
        }
        Block rhs = ((Block) other);
        return new EqualsBuilder().append(text, rhs.text).append(accessory, rhs.accessory).append(blockId, rhs.blockId).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).append(fields, rhs.fields).isEquals();
    }

}
