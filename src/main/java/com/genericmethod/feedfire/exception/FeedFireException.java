package com.genericmethod.feedfire.exception;

import org.apache.log4j.Logger;


public class FeedFireException extends Exception {

  private static final long serialVersionUID = 3108043906546311376L;

  private static Logger log = Logger.getLogger(FeedFireException.class);

  public FeedFireException() {
  }

  public FeedFireException(String message) {
    super(message);
    log.error(message);
  }

  public FeedFireException(Throwable cause) {
    super(cause);
    log.error(cause);
  }

  public FeedFireException(String message, Throwable cause) {
    super(message, cause);
    log.error(message, cause);
  }
}
