package com.genericmethod.feedfire.sample;

import com.genericmethod.feedfire.cache.AbstractCacheService;
import com.genericmethod.feedfire.event.AbstractEventNotifier;
import com.genericmethod.feedfire.event.AbstractEventProducer;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cfarrugia
 */
@Component
public class SampleEventNotifier extends AbstractEventNotifier<Sample> {

    @Autowired private SampleCacheService sampleCacheService;
    @Autowired private SampleEventProducer sampleEventProducer;

    @Override
    public AbstractCacheService getCacheService() {
        return sampleCacheService;
    }

    @Override
    public AbstractEventProducer getEventProducer() {
        return sampleEventProducer;
    }

    @Override
    public Gson getGsonInstance() {
        return null;
    }
}