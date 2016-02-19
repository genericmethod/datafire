package com.genericmethod.datafire.sample;

import com.genericmethod.datafire.event.DataFireEvent;
import com.genericmethod.datafire.event.DataFireEventProducer;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SampleEventProducer extends DataFireEventProducer<Sample, SampleEventType> {

  @Override
  public void sendEvent(List<DataFireEvent<Sample, SampleEventType>> event) {

  }
}
