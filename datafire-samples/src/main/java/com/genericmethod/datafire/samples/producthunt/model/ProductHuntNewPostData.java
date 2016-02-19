
package com.genericmethod.datafire.samples.producthunt.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "posts"
})
public class ProductHuntNewPostData {

    @JsonProperty("posts")
    private List<Post> posts = new ArrayList<Post>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProductHuntNewPostData() {
    }

    /**
     * 
     * @param posts
     */
    public ProductHuntNewPostData(List<Post> posts) {
        this.posts = posts;
    }

    /**
     * 
     * @return
     *     The posts
     */
    @JsonProperty("posts")
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * 
     * @param posts
     *     The posts
     */
    @JsonProperty("posts")
    public void setPosts(List<Post> posts) {
        this.posts = posts;
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
        return new HashCodeBuilder().append(posts).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductHuntNewPostData) == false) {
            return false;
        }
        ProductHuntNewPostData rhs = ((ProductHuntNewPostData) other);
        return new EqualsBuilder().append(posts, rhs.posts).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
