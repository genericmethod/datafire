package com.genericmethod.feedfire.exception;

import org.apache.log4j.Logger;


public class DataFireException extends Exception {

  private static final long serialVersionUID = 3108043906546311376L;

  private static Logger log = Logger.getLogger(DataFireException.class);

  public DataFireException() {
  }

  public DataFireException(String message) {
    super(message);
    log.error(message);
  }

  public DataFireException(Throwable cause) {
    super(cause);
    log.error(cause);
  }

  public DataFireException(String message, Throwable cause) {
    super(message, cause);
    log.error(message, cause);
  }
}
