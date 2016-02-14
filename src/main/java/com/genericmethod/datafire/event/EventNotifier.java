package com.genericmethod.datafire.event;


import com.genericmethod.datafire.cache.CacheKey;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public interface EventNotifier<T> {
  void updateCacheAndGenerateEvents(List<T> feedObjects, ConcurrentHashMap<CacheKey, T> cachedObjects);
}
