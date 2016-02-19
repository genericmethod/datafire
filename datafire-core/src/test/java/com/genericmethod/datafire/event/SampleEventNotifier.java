package com.genericmethod.datafire.event;

import com.genericmethod.datafire.cache.DataFireInMemoryCacheService;
import com.genericmethod.datafire.sample.Sample;
import com.genericmethod.datafire.sample.SampleCacheService;
import com.genericmethod.datafire.sample.SampleEventProducer;
import com.genericmethod.datafire.sample.SampleEventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SampleEventNotifier extends DataFireEventNotifier<Sample,SampleEventType> {

  @Autowired
  private SampleCacheService sampleCacheService;
  @Autowired
  private SampleEventProducer sampleEventProducer;

  @Override
  public DataFireInMemoryCacheService getCacheService() {
    return sampleCacheService;
  }

  @Override
  public DataFireEventProducer getEventProducer() {
    return sampleEventProducer;
  }

  @Override
  public List<DataFireEvent<Sample, SampleEventType>> getEvent(Sample cachedObj, Sample dataObject) {
    return null;
  }

}
