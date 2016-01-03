package com.genericmethod.feedfire.request;


import com.genericmethod.feedfire.cache.CacheKey;
import com.genericmethod.feedfire.cache.CacheService;
import com.genericmethod.feedfire.cache.CacheableObject;
import com.genericmethod.feedfire.event.AbstractEventNotifier;
import com.genericmethod.feedfire.mapper.AbstractXmlFeedMapper;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;


/**
 * This abstract class handles the scheduled task of downloading and mapping an XML feed to objects
 * of type T and placing them in the designated cache. <p/> The scheduled tasks requires the
 * {feed.request.timer} property to be set.
 */
public abstract class AbstractFeedRequestScheduler<T extends CacheableObject> {

  private static Logger log = Logger.getLogger(AbstractFeedRequestScheduler.class);

  @Autowired
  TaskScheduler taskScheduler;

  /**
   * Returns the FeedRequester instance used to request and retrieve the xml feed.
   *
   * @return returns the {@link AbstractOkHttpFeedRequester} instance.
   */
  public abstract FeedRequester getFeedRequester();

  /**
   * Return the XmlFeedMapper instance that maps the is used to map the xml string to generic
   * objects
   *
   * @return return an {@link AbstractXmlFeedMapper} instance
   */
  public abstract AbstractXmlFeedMapper getXmlFeedMapper();

  /**
   * Return the Cache service handling generic object caching
   *
   * @return Return the Cache service handling generic object caching.
   */
  public abstract CacheService getCacheService();

  /***
   * Return the {@link AbstractEventNotifier } to be used to generate events.
   */
  public abstract AbstractEventNotifier getNotifier();

  /**
   * Fixed delay (in milliseconds) used by task scheduler.
   */
  public abstract long getFixedDelay();

  @PostConstruct
  private void init() {
    requestEventsAndSaveToCache();
  }

  /**
   * Scheduled task to request and save event details.
   */
  public void requestEventsAndSaveToCache() {

    Runnable task = new Runnable() {

      public void run() {

        try {
          log.info("Requesting feed @ [" + new DateTime() + "]");
          log.info("Fixed Delay for feed is " + getFixedDelay() + " ms");
          String feedXml = getFeedRequester().requestAndGet();

          if (StringUtils.isBlank(feedXml)) {
            log.error("Feed cannot be blank");
            return;
          }

          List<T> feedModel = (List<T>) getXmlFeedMapper().mapXmlToModel(feedXml);
          ConcurrentHashMap<CacheKey, T> tempObjCache = getCacheService().getAll();
          getNotifier().updateCacheAndGenerateEvents(feedModel, tempObjCache);

        } catch (Throwable t) {
          log.error("An un-expected error occurred while retrieving objects for feed @[" + new DateTime() + "]", t);
        }

      }
    };

    taskScheduler.scheduleWithFixedDelay(task, getFixedDelay());
    log.info("Initialized scheduled task for feed with fixed delay of " + getFixedDelay() + " ms");
  }

}
