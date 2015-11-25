package com.genericmethod.feedfire.sample;

import com.genericmethod.feedfire.request.AbstractFeedRequester;
import org.springframework.stereotype.Component;

@Component
public class SampleFeedRequester extends AbstractFeedRequester {

    @Override
    public String getFeedUrl() {
        return "http://www.samplefeed.com/sample.xml";
    }

    @Override
    public Integer getMaximumRetry() {
        return 3;
    }
}
