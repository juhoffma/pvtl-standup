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
        "channel",
        "blocks"
})
public class Message {

    @JsonProperty("channel")
    private String channel;
    @JsonProperty("blocks")
    private List<Block> blocks = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Message() {
    }

    /**
     * @param blocks
     * @param channel
     */
    public Message(String channel, List<Block> blocks) {
        super();
        this.channel = channel;
        this.blocks = blocks;
    }

    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Message withChannel(String channel) {
        this.channel = channel;
        return this;
    }

    @JsonProperty("blocks")
    public List<Block> getBlocks() {
        return blocks;
    }

    @JsonProperty("blocks")
    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public Message withBlocks(List<Block> blocks) {
        this.blocks = blocks;
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

    public Message withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("channel", channel).append("blocks", blocks).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(blocks).append(channel).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Message) == false) {
            return false;
        }
        Message rhs = ((Message) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(blocks, rhs.blocks).append(channel, rhs.channel).isEquals();
    }

}
