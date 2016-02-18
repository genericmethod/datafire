package com.genericmethod.datafire.sample;

import com.genericmethod.datafire.cache.CacheService;
import com.genericmethod.datafire.event.DataFireEventNotifier;
import com.genericmethod.datafire.mapper.DataFireMapper;
import com.genericmethod.datafire.request.DataFireRequestScheduler;
import com.genericmethod.datafire.request.DataFireRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SampleFeedRequestScheduler extends DataFireRequestScheduler<Sample> {

  @Autowired
  private SampleFeedRequester sampleFeedRequester;
  @Autowired
  private SampleXmlFeedMapper sampleXmlFeedMapper;
  @Autowired
  private SampleCacheService sampleCacheService;
  @Autowired
  private SampleEventNotifier sampleNotifier;

  @Override
  public DataFireRequester getRequester() {
    return sampleFeedRequester;
  }

  @Override
  public DataFireMapper getMapper() {
    return sampleXmlFeedMapper;
  }

  @Override
  public CacheService getCacheService() {
    return sampleCacheService;
  }

  @Override
  public DataFireEventNotifier getNotifier() {
    return sampleNotifier;
  }

}
