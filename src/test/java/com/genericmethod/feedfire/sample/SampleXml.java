package com.genericmethod.feedfire.sample;

import com.genericmethod.feedfire.cache.CacheableObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * @author cfarrugia
 */
@XStreamAlias("sampleXml")
public class SampleXml {
    @XStreamImplicit(itemFieldName = "sample")
    List<Sample> samples;

    public List<Sample> getSamples() {
        return samples;
    }

    public void setSamples(List<Sample> samples) {
        this.samples = samples;
    }
}
