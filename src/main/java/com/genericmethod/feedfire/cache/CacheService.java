package com.genericmethod.feedfire.cache;


import java.util.concurrent.ConcurrentHashMap;

public interface CacheService<T> {
  void put(CacheKey key, T obj);

  void remove(CacheKey key);

  T get(CacheKey key) throws Exception;

  ConcurrentHashMap<CacheKey, T> getAll();
}
