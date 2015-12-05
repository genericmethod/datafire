package com.genericmethod.feedfire.sample;

import com.genericmethod.feedfire.cache.AbstractCacheService;
import com.genericmethod.feedfire.cache.CacheService;
import com.genericmethod.feedfire.event.AbstractEventNotifier;
import com.genericmethod.feedfire.mapper.AbstractXmlFeedMapper;
import com.genericmethod.feedfire.request.AbstractFeedRequestScheduler;
import com.genericmethod.feedfire.request.FeedRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SampleFeedRequestScheduler extends AbstractFeedRequestScheduler<Sample>{

    @Autowired private SampleFeedRequester sampleFeedRequester;
    @Autowired private SampleXmlFeedMapper sampleXmlFeedMapper;
    @Autowired private SampleCacheService sampleCacheService;
    @Autowired private SampleEventNotifier sampleNotifier;

    @Override
    public FeedRequester getFeedRequester() {
        return sampleFeedRequester;
    }

    @Override
    public AbstractXmlFeedMapper getXmlFeedMapper() {
        return sampleXmlFeedMapper;
    }

    @Override
    public CacheService getCacheService() {
        return sampleCacheService;
    }

    @Override
    public AbstractEventNotifier getNotifier() {
        return sampleNotifier;
    }

    @Override
    public long getFixedDelay() {
        return 5000;
    }
}
