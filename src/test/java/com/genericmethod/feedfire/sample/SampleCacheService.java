package com.genericmethod.feedfire.sample;

import com.genericmethod.feedfire.cache.AbstractCacheService;
import com.google.code.ssm.CacheFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class SampleCacheService extends AbstractCacheService<Sample> {

    public static final String SAMPLE_CACHE_NAME = "sampleCache";
    public static final String MEMCACHED_LOCATION = "localhost:11211";

    @Autowired
    @Qualifier("sampleCacheFactory")
    CacheFactory sampleCacheFactory;

    @Override
    protected String getFeedCacheName() {
        return SAMPLE_CACHE_NAME;
    }

    @Override
    protected String getMemcachedLocation() {
        return MEMCACHED_LOCATION;
    }

    @Override
    protected CacheFactory getFeedCacheFactory() {
        return sampleCacheFactory;
    }
}
