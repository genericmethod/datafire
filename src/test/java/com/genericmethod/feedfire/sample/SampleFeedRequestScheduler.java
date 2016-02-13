package com.genericmethod.feedfire.sample;

import com.genericmethod.feedfire.cache.CacheService;
import com.genericmethod.feedfire.event.DataFireEventNotifier;
import com.genericmethod.feedfire.mapper.DataFireMapper;
import com.genericmethod.feedfire.request.DataFireRequestScheduler;
import com.genericmethod.feedfire.request.DataFireRequester;
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

  @Override
  public long getFixedDelay() {
    return 5000;
  }
}
