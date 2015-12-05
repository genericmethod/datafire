package com.genericmethod.feedfire.sample;

import com.genericmethod.feedfire.cache.AbstractInMemoryCacheService;
import com.genericmethod.feedfire.event.AbstractEventNotifier;
import com.genericmethod.feedfire.event.AbstractEventProducer;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleEventNotifier extends AbstractEventNotifier<Sample> {

    @Autowired private SampleCacheService sampleCacheService;
    @Autowired private SampleEventProducer sampleEventProducer;

    @Override
    public AbstractInMemoryCacheService getCacheService() {
        return sampleCacheService;
    }

    @Override
    public AbstractEventProducer getEventProducer() {
        return sampleEventProducer;
    }

    @Override
    public Gson getGsonInstance() {
        return new Gson();
    }
}
