package com.genericmethod.datafire.mapper;

import com.genericmethod.datafire.exception.DataFireException;

import java.util.List;

/**
 * Handles mapping of a data (represented as a String) to a generic model object T
 * The data string can be represented in various formats such as Json, XML or CSV
 */
public abstract class DataFireMapper<T> {

  /**
   * Return a generic model object containing data mapped from the data string.
   *
   * @param data A string representation of the data to be mapped
   * @return A generic model object T containing the mapped data.
   */
  public abstract List<T> mapToModel(String data) throws DataFireException;

}
