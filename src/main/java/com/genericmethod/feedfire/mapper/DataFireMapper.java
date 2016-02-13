package com.genericmethod.feedfire.mapper;

import com.genericmethod.feedfire.exception.FeedFireException;

import java.util.List;

/**
 * Handles mapping of a data (represented as a String) to a generic model object T
 */
public abstract class DataFireMapper<T> {

  /**
   * Return a generic model object containing data mapped from the xml feed.
   *
   * @param feedXml The xml feed to be mapped
   * @return A generic model object T containing the xml feed data.
   */
  public abstract List<T> mapToModel(String feedXml) throws FeedFireException;

}
