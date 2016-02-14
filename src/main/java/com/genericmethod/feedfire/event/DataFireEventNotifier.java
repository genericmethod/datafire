package com.genericmethod.feedfire.event;

import com.genericmethod.feedfire.cache.CacheKey;
import com.genericmethod.feedfire.cache.CacheService;
import com.genericmethod.feedfire.cache.CacheableObject;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class DataFireEventNotifier<T extends CacheableObject, E> implements
        EventNotifier<T> {

  private static Logger log = Logger.getLogger(DataFireEventNotifier.class);

  /**
   * Return the Cache service handling object caching
   *
   * @return Return the Cache service handling object caching.
   */
  public abstract CacheService getCacheService();

  /***
   * Return the {@link DataFireEventProducer } to be used to publish Events.
   */
  public abstract DataFireEventProducer getEventProducer();

  public abstract List<DataFireEvent<T,E>> getEvent(T cachedObj, T feedObject);

  /***
   * Compare the objects that have been returned from the feed to the objects that are currently in
   * cache. Update cache and generate the required events.
   *
   * @param currentObjects   The objects that are currently in the feed.
   * @param cachedObjects The objects that are currently in the cache.
   */
  public void updateCacheAndGenerateEvents(List<T> currentObjects, ConcurrentHashMap<CacheKey, T> cachedObjects) {

    if (currentObjects == null) {
      return;
    }

    if (cachedObjects == null) {
      return;
    }

    Iterator<T> currentObjectsIterator = currentObjects.iterator();

    log.info(String.format("Total keys in cache: %s", cachedObjects.keySet().size()));
    log.info(String.format("Total keys in feed: %s", currentObjects.size()));

    while (currentObjectsIterator.hasNext()) {
      T currentObj = currentObjectsIterator.next();

      CacheKey cacheKey = new CacheKey(currentObj.getCacheId());
      T cachedObj = cachedObjects.get(cacheKey);
      getCacheService().put(cacheKey, currentObj);

      List<DataFireEvent<T, E>> event = getEvent(cachedObj, currentObj);
      getEventProducer().sendEvent(event);
    }
  }
}
