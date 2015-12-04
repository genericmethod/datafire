package com.genericmethod.feedfire.sample;

import com.genericmethod.feedfire.event.AbstractEventProducer;
import com.genericmethod.feedfire.event.Event;
import org.springframework.stereotype.Component;


@Component
public class SampleEventProducer extends AbstractEventProducer<SampleXml> {

    @Override
    public void sendEvent(Event<SampleXml> event) {
        //do something
        //call a service
        //send on a message queue
    }
}
