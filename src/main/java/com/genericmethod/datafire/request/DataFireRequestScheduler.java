package com.genericmethod.datafire.request;


import com.genericmethod.datafire.cache.CacheKey;
import com.genericmethod.datafire.cache.CacheService;
import com.genericmethod.datafire.cache.CacheableObject;
import com.genericmethod.datafire.event.DataFireEventNotifier;
import com.genericmethod.datafire.mapper.DataFireMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


/**
 * This abstract class handles the scheduled task of downloading and mapping an XML feed to objects
 * of type T and placing them in the designated cache. <p/> The scheduled tasks requires the
 * {feed.request.timer} property to be set.
 */
public abstract class DataFireRequestScheduler<T extends CacheableObject> {

  private static Logger log = Logger.getLogger(DataFireRequestScheduler.class);

  /**
   * Returns the FeedRequester instance used to request and retrieve the xml feed.
   *
   * @return returns the {@link DataFireOkHttpRequester} instance.
   */
  public abstract DataFireRequester getRequester();

  /**
   * Return the XmlFeedMapper instance that maps the is used to map the xml string to generic
   * objects
   *
   * @return return an {@link DataFireMapper} instance
   */
  public abstract DataFireMapper getMapper();

  /**
   * Return the Cache service handling generic object caching
   *
   * @return Return the Cache service handling generic object caching.
   */
  public abstract CacheService getCacheService();

  /***
   * Return the {@link DataFireEventNotifier } to be used to generate events.
   */
  public abstract DataFireEventNotifier getNotifier();

  /**
   * Fixed delay (in milliseconds) used by task scheduler.
   */
  public abstract long getFixedDelay();

  @PostConstruct
  private void init() {
    work();
  }

  /**
   * Scheduled task to request and save event details.
   */
  public void work() {

    try {
      log.info("Requesting data @ [" + new DateTime() + "]");
      log.info("Fixed Delay for data is " + getFixedDelay() + " ms");
      String data = getRequester().requestAndGet();

      if (StringUtils.isBlank(data)) {
        log.error("Feed cannot be blank");
        return;
      }

      List<T> dataModel = (List<T>) getMapper().mapToModel(data);
      ConcurrentHashMap<CacheKey, T> tempObjCache = getCacheService().getAll();
      getNotifier().updateCacheAndGenerateEvents(dataModel, tempObjCache);

    } catch (Throwable t) {
      log.error("An un-expected error occurred while retrieving objects for feed @[" + new DateTime() + "]", t);
    }

  }
}

