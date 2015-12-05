package com.genericmethod.feedfire.event;

import com.genericmethod.feedfire.cache.CacheKey;
import com.genericmethod.feedfire.cache.CacheService;
import com.genericmethod.feedfire.cache.CacheableObject;
import com.genericmethod.feedfire.enums.EventType;

import com.google.gson.Gson;

import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractEventNotifier<T extends CacheableObject> implements EventNotifier<T> {

  private static Logger log = Logger.getLogger(AbstractEventNotifier.class);

  /**
   * Return the Cache service handling object caching
   *
   * @return Return the Cache service handling object caching.
   */
  public abstract CacheService getCacheService();

  /***
   * Return the {@link AbstractEventProducer } to be used to publish Events.
   */
  public abstract AbstractEventProducer getEventProducer();

  /**
   * The Gson instance is used to detect any object changes.
   */
  public abstract Gson getGsonInstance();



  /***
   * Compare the objects that have been returned from the feed to the objects that are currently in
   * cache. Update cache and generate the required events.
   *
   * @param feedObjects   The objects that are currently in the feed.
   * @param cachedObjects The objects that are currently in the cache.
   */
  public void updateCacheAndGenerateEvents(List<T> feedObjects, ConcurrentHashMap<CacheKey, T> cachedObjects) {

    if (feedObjects == null)
      return;

    if (cachedObjects == null)
      return;

    Iterator<T> feedObjectsIterator = feedObjects.iterator();

    log.info(String.format("Total keys in cache: %s", cachedObjects.keySet().size()));
    log.info(String.format("Total keys in feed: %s", feedObjects.size()));

    while (feedObjectsIterator.hasNext()) {
      CacheableObject feedObj = feedObjectsIterator.next();

      CacheKey cacheKey = new CacheKey(feedObj.getCacheId());
      T cachedObj = cachedObjects.get(cacheKey);

      if (cachedObj == null) {
        getCacheService().put(cacheKey, feedObj);
        getEventProducer().sendEvent(new Event<>(feedObj, EventType.CREATED));
      } else {

        String feedJSON = getGsonInstance().toJson(feedObj);
        String cachedJSON = getGsonInstance().toJson(cachedObj);

        //when the objects do not match, update our in memory cache and send an event
        if (!feedJSON.equals(cachedJSON)) {
          getCacheService().put(cacheKey, feedObj);
          getEventProducer().sendEvent(new Event<>(feedObj, EventType.UPDATED));
        }

        //remove cache items so that we are left with objects to be deleted only
        cachedObjects.remove(cacheKey);
      }
    }

    for (CacheKey key : cachedObjects.keySet()) {
      //all items in here - will generate a delete Notification and should be removed from cache
      getCacheService().remove(key);
      //notification generation
      getEventProducer().sendEvent(new Event<>(cachedObjects.get(key), EventType.DELETED));
    }

  }

}
