package com.genericmethod.datafire.sample;

import com.genericmethod.datafire.cache.DataFireInMemoryCacheService;
import org.springframework.stereotype.Component;


@Component
public class SampleCacheService extends DataFireInMemoryCacheService<Sample> {

}
