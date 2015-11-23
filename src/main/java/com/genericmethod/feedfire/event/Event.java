package com.genericmethod.feedfire.event;

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

}