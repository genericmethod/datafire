package com.genericmethod.feedfire.sample;

import com.genericmethod.feedfire.event.DataFireEventProducer;
import com.genericmethod.feedfire.event.Event;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SampleEventProducer extends DataFireEventProducer<Sample, SampleEventType> {

  @Override
  public void sendEvent(List<Event<Sample, SampleEventType>> event) {

  }
}
