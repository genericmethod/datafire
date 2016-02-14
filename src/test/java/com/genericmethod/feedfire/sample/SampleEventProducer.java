package com.genericmethod.feedfire.sample;

import com.genericmethod.feedfire.event.DataFireEvent;
import com.genericmethod.feedfire.event.DataFireEventProducer;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SampleEventProducer extends DataFireEventProducer<Sample, SampleEventType> {

  @Override
  public void sendEvent(List<DataFireEvent<Sample, SampleEventType>> event) {

  }
}
