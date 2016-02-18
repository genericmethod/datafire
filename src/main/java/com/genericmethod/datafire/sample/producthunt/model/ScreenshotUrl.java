
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
    "300px",
    "850px"
})
public class ScreenshotUrl {

    @JsonProperty("300px")
    private String _300px;
    @JsonProperty("850px")
    private String _850px;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ScreenshotUrl() {
    }

    /**
     * 
     * @param _300px
     * @param _850px
     */
    public ScreenshotUrl(String _300px, String _850px) {
        this._300px = _300px;
        this._850px = _850px;
    }

    /**
     * 
     * @return
     *     The _300px
     */
    @JsonProperty("300px")
    public String get300px() {
        return _300px;
    }

    /**
     * 
     * @param _300px
     *     The 300px
     */
    @JsonProperty("300px")
    public void set300px(String _300px) {
        this._300px = _300px;
    }

    /**
     * 
     * @return
     *     The _850px
     */
    @JsonProperty("850px")
    public String get850px() {
        return _850px;
    }

    /**
     * 
     * @param _850px
     *     The 850px
     */
    @JsonProperty("850px")
    public void set850px(String _850px) {
        this._850px = _850px;
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
        return new HashCodeBuilder().append(_300px).append(_850px).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ScreenshotUrl) == false) {
            return false;
        }
        ScreenshotUrl rhs = ((ScreenshotUrl) other);
        return new EqualsBuilder().append(_300px, rhs._300px).append(_850px, rhs._850px).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
