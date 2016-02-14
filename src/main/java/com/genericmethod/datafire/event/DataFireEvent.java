package com.genericmethod.datafire.event;

import com.google.common.base.Objects;

import java.io.Serializable;

public class DataFireEvent<T, E> implements Serializable, Cloneable {

  private static final long serialVersionUID = 66944887456944553L;
  private T message;
  private E eventType;

  public DataFireEvent(T message, E status) {
    this.message = message;
    this.eventType = status;
  }


  @Override
  public String toString() {
    return "Notification [notification=" + eventType + "]";
  }

  public T getMessage() {
    return message;
  }

  public void setMessage(T message) {
    this.message = message;
  }

  public E getEventType() {
    return eventType;
  }

  public void setEventType(E eventType) {
    this.eventType = eventType;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    DataFireEvent that = (DataFireEvent) o;

    return Objects.equal(this.message, that.message)
            && Objects.equal(this.eventType, that.eventType);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(message, eventType);
  }
}