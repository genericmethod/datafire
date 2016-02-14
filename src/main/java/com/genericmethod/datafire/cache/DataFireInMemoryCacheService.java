package com.genericmethod.datafire.cache;

import java.util.concurrent.ConcurrentHashMap;

public class DataFireInMemoryCacheService<T extends CacheableObject> implements CacheService<T> {

  private ConcurrentHashMap<CacheKey, T> map = new ConcurrentHashMap<>();

  @Override
  public void put(CacheKey key, T obj) {
    map.put(key, obj);
  }

  @Override
  public void remove(CacheKey key) {
    map.remove(key);
  }

  @Override
  public T get(CacheKey key) throws Exception {
    return map.get(key);
  }

  @Override
  public ConcurrentHashMap<CacheKey, T> getAll() {
    return map;
  }
}
