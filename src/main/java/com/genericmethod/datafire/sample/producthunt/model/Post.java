
package com.genericmethod.datafire.sample.producthunt.model;

import com.fasterxml.jackson.annotation.*;
import com.genericmethod.datafire.cache.CacheableObject;
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
    "category_id",
    "day",
    "id",
    "name",
    "product_state",
    "tagline",
    "comments_count",
    "created_at",
    "current_user",
    "discussion_url",
    "exclusive",
    "featured",
    "maker_inside",
    "makers",
    "platforms",
    "redirect_url",
    "screenshot_url",
    "thumbnail",
    "user",
    "votes_count"
})
public class Post extends CacheableObject{

    @JsonProperty("category_id")
    private Integer categoryId;
    @JsonProperty("day")
    private String day;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("product_state")
    private String productState;
    @JsonProperty("tagline")
    private String tagline;
    @JsonProperty("comments_count")
    private Integer commentsCount;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("current_user")
    private CurrentUser currentUser;
    @JsonProperty("discussion_url")
    private String discussionUrl;
    @JsonProperty("exclusive")
    private Exclusive exclusive;
    @JsonProperty("featured")
    private Boolean featured;
    @JsonProperty("maker_inside")
    private Boolean makerInside;
    @JsonProperty("makers")
    private List<Object> makers = new ArrayList<Object>();
    @JsonProperty("platforms")
    private List<Object> platforms = new ArrayList<Object>();
    @JsonProperty("redirect_url")
    private String redirectUrl;
    @JsonProperty("screenshot_url")
    private ScreenshotUrl screenshotUrl;
    @JsonProperty("thumbnail")
    private Thumbnail thumbnail;
    @JsonProperty("user")
    private User_ user;
    @JsonProperty("votes_count")
    private Integer votesCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Post() {
    }

    /**
     * 
     * @param votesCount
     * @param currentUser
     * @param exclusive
     * @param categoryId
     * @param commentsCount
     * @param featured
     * @param platforms
     * @param productState
     * @param discussionUrl
     * @param id
     * @param makerInside
     * @param thumbnail
     * @param screenshotUrl
     * @param createdAt
     * @param name
     * @param makers
     * @param day
     * @param user
     * @param redirectUrl
     * @param tagline
     */
    public Post(Integer categoryId, String day, Integer id, String name, String productState, String tagline, Integer commentsCount, String createdAt, CurrentUser currentUser, String discussionUrl, Exclusive exclusive, Boolean featured, Boolean makerInside, List<Object> makers, List<Object> platforms, String redirectUrl, ScreenshotUrl screenshotUrl, Thumbnail thumbnail, User_ user, Integer votesCount) {
        this.categoryId = categoryId;
        this.day = day;
        this.id = id;
        this.name = name;
        this.productState = productState;
        this.tagline = tagline;
        this.commentsCount = commentsCount;
        this.createdAt = createdAt;
        this.currentUser = currentUser;
        this.discussionUrl = discussionUrl;
        this.exclusive = exclusive;
        this.featured = featured;
        this.makerInside = makerInside;
        this.makers = makers;
        this.platforms = platforms;
        this.redirectUrl = redirectUrl;
        this.screenshotUrl = screenshotUrl;
        this.thumbnail = thumbnail;
        this.user = user;
        this.votesCount = votesCount;
    }

    /**
     * 
     * @return
     *     The categoryId
     */
    @JsonProperty("category_id")
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 
     * @param categoryId
     *     The category_id
     */
    @JsonProperty("category_id")
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 
     * @return
     *     The day
     */
    @JsonProperty("day")
    public String getDay() {
        return day;
    }

    /**
     * 
     * @param day
     *     The day
     */
    @JsonProperty("day")
    public void setDay(String day) {
        this.day = day;
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
     *     The productState
     */
    @JsonProperty("product_state")
    public String getProductState() {
        return productState;
    }

    /**
     * 
     * @param productState
     *     The product_state
     */
    @JsonProperty("product_state")
    public void setProductState(String productState) {
        this.productState = productState;
    }

    /**
     * 
     * @return
     *     The tagline
     */
    @JsonProperty("tagline")
    public String getTagline() {
        return tagline;
    }

    /**
     * 
     * @param tagline
     *     The tagline
     */
    @JsonProperty("tagline")
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    /**
     * 
     * @return
     *     The commentsCount
     */
    @JsonProperty("comments_count")
    public Integer getCommentsCount() {
        return commentsCount;
    }

    /**
     * 
     * @param commentsCount
     *     The comments_count
     */
    @JsonProperty("comments_count")
    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
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
     *     The currentUser
     */
    @JsonProperty("current_user")
    public CurrentUser getCurrentUser() {
        return currentUser;
    }

    /**
     * 
     * @param currentUser
     *     The current_user
     */
    @JsonProperty("current_user")
    public void setCurrentUser(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * 
     * @return
     *     The discussionUrl
     */
    @JsonProperty("discussion_url")
    public String getDiscussionUrl() {
        return discussionUrl;
    }

    /**
     * 
     * @param discussionUrl
     *     The discussion_url
     */
    @JsonProperty("discussion_url")
    public void setDiscussionUrl(String discussionUrl) {
        this.discussionUrl = discussionUrl;
    }

    /**
     * 
     * @return
     *     The exclusive
     */
    @JsonProperty("exclusive")
    public Exclusive getExclusive() {
        return exclusive;
    }

    /**
     * 
     * @param exclusive
     *     The exclusive
     */
    @JsonProperty("exclusive")
    public void setExclusive(Exclusive exclusive) {
        this.exclusive = exclusive;
    }

    /**
     * 
     * @return
     *     The featured
     */
    @JsonProperty("featured")
    public Boolean getFeatured() {
        return featured;
    }

    /**
     * 
     * @param featured
     *     The featured
     */
    @JsonProperty("featured")
    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    /**
     * 
     * @return
     *     The makerInside
     */
    @JsonProperty("maker_inside")
    public Boolean getMakerInside() {
        return makerInside;
    }

    /**
     * 
     * @param makerInside
     *     The maker_inside
     */
    @JsonProperty("maker_inside")
    public void setMakerInside(Boolean makerInside) {
        this.makerInside = makerInside;
    }

    /**
     * 
     * @return
     *     The makers
     */
    @JsonProperty("makers")
    public List<Object> getMakers() {
        return makers;
    }

    /**
     * 
     * @param makers
     *     The makers
     */
    @JsonProperty("makers")
    public void setMakers(List<Object> makers) {
        this.makers = makers;
    }

    /**
     * 
     * @return
     *     The platforms
     */
    @JsonProperty("platforms")
    public List<Object> getPlatforms() {
        return platforms;
    }

    /**
     * 
     * @param platforms
     *     The platforms
     */
    @JsonProperty("platforms")
    public void setPlatforms(List<Object> platforms) {
        this.platforms = platforms;
    }

    /**
     * 
     * @return
     *     The redirectUrl
     */
    @JsonProperty("redirect_url")
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * 
     * @param redirectUrl
     *     The redirect_url
     */
    @JsonProperty("redirect_url")
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    /**
     * 
     * @return
     *     The screenshotUrl
     */
    @JsonProperty("screenshot_url")
    public ScreenshotUrl getScreenshotUrl() {
        return screenshotUrl;
    }

    /**
     * 
     * @param screenshotUrl
     *     The screenshot_url
     */
    @JsonProperty("screenshot_url")
    public void setScreenshotUrl(ScreenshotUrl screenshotUrl) {
        this.screenshotUrl = screenshotUrl;
    }

    /**
     * 
     * @return
     *     The thumbnail
     */
    @JsonProperty("thumbnail")
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    /**
     * 
     * @param thumbnail
     *     The thumbnail
     */
    @JsonProperty("thumbnail")
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * 
     * @return
     *     The user
     */
    @JsonProperty("user")
    public User_ getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    @JsonProperty("user")
    public void setUser(User_ user) {
        this.user = user;
    }

    /**
     * 
     * @return
     *     The votesCount
     */
    @JsonProperty("votes_count")
    public Integer getVotesCount() {
        return votesCount;
    }

    /**
     * 
     * @param votesCount
     *     The votes_count
     */
    @JsonProperty("votes_count")
    public void setVotesCount(Integer votesCount) {
        this.votesCount = votesCount;
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
        return new HashCodeBuilder().append(categoryId).append(day).append(id).append(name).append(productState).append(tagline).append(commentsCount).append(createdAt).append(currentUser).append(discussionUrl).append(exclusive).append(featured).append(makerInside).append(makers).append(platforms).append(redirectUrl).append(screenshotUrl).append(thumbnail).append(user).append(votesCount).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Post) == false) {
            return false;
        }
        Post rhs = ((Post) other);
        return new EqualsBuilder().append(categoryId, rhs.categoryId).append(day, rhs.day).append(id, rhs.id).append(name, rhs.name).append(productState, rhs.productState).append(tagline, rhs.tagline).append(commentsCount, rhs.commentsCount).append(createdAt, rhs.createdAt).append(currentUser, rhs.currentUser).append(discussionUrl, rhs.discussionUrl).append(exclusive, rhs.exclusive).append(featured, rhs.featured).append(makerInside, rhs.makerInside).append(makers, rhs.makers).append(platforms, rhs.platforms).append(redirectUrl, rhs.redirectUrl).append(screenshotUrl, rhs.screenshotUrl).append(thumbnail, rhs.thumbnail).append(user, rhs.user).append(votesCount, rhs.votesCount).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @Override
    public String getCacheId() {
        return getId().toString();
    }
}
