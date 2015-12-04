package com.genericmethod.feedfire.event;


import com.genericmethod.feedfire.cache.CacheKey;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public interface EventNotifier<T> {
   void updateCacheAndGenerateEvents(List<T> feedObjects, ConcurrentHashMap<CacheKey, T> cachedObjects);
}
