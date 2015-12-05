package com.genericmethod.feedfire.enums;

/**
 * @author cfarrugia
 */
public enum EventType {

  CREATED("CREATED"),
  UPDATED("UPDATED"),
  DELETED("DELETED");

  private final String name;

  EventType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
