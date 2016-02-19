package com.genericmethod.datafire.filter;


/**
 * Filter Interface that filters an object of Type T
 *
 * @param <T> The type of object to be filtered
 */
public interface Filter<T> {
  T apply(T objects);
}
