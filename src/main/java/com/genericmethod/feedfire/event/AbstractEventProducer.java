package com.genericmethod.feedfire.event;


public abstract  class AbstractEventProducer<T> {

    public abstract void sendEvent(final Event<T> event);
}
