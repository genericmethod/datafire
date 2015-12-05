package com.genericmethod.feedfire.sample;

import com.genericmethod.feedfire.cache.AbstractCacheService;
import com.genericmethod.feedfire.cache.AbstractInMemoryCacheService;

import com.google.code.ssm.CacheFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class SampleCacheService extends AbstractInMemoryCacheService<Sample> {

}
