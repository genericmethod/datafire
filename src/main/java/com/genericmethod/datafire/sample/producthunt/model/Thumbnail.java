
package com.genericmethod.datafire.sample.producthunt.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "media_type",
    "image_url",
    "metadata"
})
public class Thumbnail {

    @JsonProperty("id")
    private Object id;
    @JsonProperty("media_type")
    private String mediaType;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Thumbnail() {
    }

    /**
     * 
     * @param id
     * @param imageUrl
     * @param mediaType
     * @param metadata
     */
    public Thumbnail(Object id, String mediaType, String imageUrl, Metadata metadata) {
        this.id = id;
        this.mediaType = mediaType;
        this.imageUrl = imageUrl;
        this.metadata = metadata;
    }

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public Object getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Object id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The mediaType
     */
    @JsonProperty("media_type")
    public String getMediaType() {
        return mediaType;
    }

    /**
     * 
     * @param mediaType
     *     The media_type
     */
    @JsonProperty("media_type")
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * 
     * @return
     *     The imageUrl
     */
    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 
     * @param imageUrl
     *     The image_url
     */
    @JsonProperty("image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 
     * @return
     *     The metadata
     */
    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * 
     * @param metadata
     *     The metadata
     */
    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(mediaType).append(imageUrl).append(metadata).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Thumbnail) == false) {
            return false;
        }
        Thumbnail rhs = ((Thumbnail) other);
        return new EqualsBuilder().append(id, rhs.id).append(mediaType, rhs.mediaType).append(imageUrl, rhs.imageUrl).append(metadata, rhs.metadata).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
