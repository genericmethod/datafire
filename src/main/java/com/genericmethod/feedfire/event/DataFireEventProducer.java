package com.genericmethod.feedfire.event;

import java.util.List;

public abstract class DataFireEventProducer<T,E> {

  public abstract void sendEvent(final List<DataFireEvent<T, E>> event);
}
