package com.genericmethod.feedfire.event;

import com.google.common.base.Objects;

import com.genericmethod.feedfire.enums.EventType;

import java.io.Serializable;

public class Event<T> implements Serializable, Cloneable {

  private static final long serialVersionUID = 66944887456944553L;

  public Event(T message, EventType status) {
    this.message = message;
    this.status = status;
  }

  private T message;
  private EventType status;

  @Override
  public String toString() {
    return "Notification [notification=" + status + "]";
  }

  public T getMessage() {
    return message;
  }

  public void setMessage(T message) {
    this.message = message;
  }

  public EventType getStatus() {
    return status;
  }

  public void setStatus(EventType status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Event that = (Event) o;

    return Objects.equal(this.message, that.message) &&
            Objects.equal(this.status, that.status);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(message, status);
  }
}