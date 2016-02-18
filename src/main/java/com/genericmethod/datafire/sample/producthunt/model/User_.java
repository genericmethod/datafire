
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
    "name",
    "headline",
    "created_at",
    "username",
    "twitter_username",
    "website_url",
    "image_url",
    "profile_url"
})
public class User_ {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("headline")
    private String headline;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("username")
    private String username;
    @JsonProperty("twitter_username")
    private String twitterUsername;
    @JsonProperty("website_url")
    private String websiteUrl;
    @JsonProperty("image_url")
    private ImageUrl_ imageUrl;
    @JsonProperty("profile_url")
    private String profileUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public User_() {
    }

    /**
     * 
     * @param headline
     * @param id
     * @param username
     * @param profileUrl
     * @param imageUrl
     * @param createdAt
     * @param name
     * @param websiteUrl
     * @param twitterUsername
     */
    public User_(Integer id, String name, String headline, String createdAt, String username, String twitterUsername, String websiteUrl, ImageUrl_ imageUrl, String profileUrl) {
        this.id = id;
        this.name = name;
        this.headline = headline;
        this.createdAt = createdAt;
        this.username = username;
        this.twitterUsername = twitterUsername;
        this.websiteUrl = websiteUrl;
        this.imageUrl = imageUrl;
        this.profileUrl = profileUrl;
    }

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The headline
     */
    @JsonProperty("headline")
    public String getHeadline() {
        return headline;
    }

    /**
     * 
     * @param headline
     *     The headline
     */
    @JsonProperty("headline")
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    /**
     * 
     * @return
     *     The createdAt
     */
    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The created_at
     */
    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     * @return
     *     The username
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The twitterUsername
     */
    @JsonProperty("twitter_username")
    public String getTwitterUsername() {
        return twitterUsername;
    }

    /**
     * 
     * @param twitterUsername
     *     The twitter_username
     */
    @JsonProperty("twitter_username")
    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    /**
     * 
     * @return
     *     The websiteUrl
     */
    @JsonProperty("website_url")
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    /**
     * 
     * @param websiteUrl
     *     The website_url
     */
    @JsonProperty("website_url")
    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    /**
     * 
     * @return
     *     The imageUrl
     */
    @JsonProperty("image_url")
    public ImageUrl_ getImageUrl() {
        return imageUrl;
    }

    /**
     * 
     * @param imageUrl
     *     The image_url
     */
    @JsonProperty("image_url")
    public void setImageUrl(ImageUrl_ imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 
     * @return
     *     The profileUrl
     */
    @JsonProperty("profile_url")
    public String getProfileUrl() {
        return profileUrl;
    }

    /**
     * 
     * @param profileUrl
     *     The profile_url
     */
    @JsonProperty("profile_url")
    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
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
        return new HashCodeBuilder().append(id).append(name).append(headline).append(createdAt).append(username).append(twitterUsername).append(websiteUrl).append(imageUrl).append(profileUrl).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof User_) == false) {
            return false;
        }
        User_ rhs = ((User_) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(headline, rhs.headline).append(createdAt, rhs.createdAt).append(username, rhs.username).append(twitterUsername, rhs.twitterUsername).append(websiteUrl, rhs.websiteUrl).append(imageUrl, rhs.imageUrl).append(profileUrl, rhs.profileUrl).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
