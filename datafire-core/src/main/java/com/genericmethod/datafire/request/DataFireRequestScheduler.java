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
 * This abstract class runs a scheduled task that pulls data from the data source and maps them objects
 * of type T and places them in the cache <p/>
 */
public abstract class DataFireRequestScheduler<T extends CacheableObject> {

  private static Logger log = Logger.getLogger(DataFireRequestScheduler.class);

  /**
   * Returns the DataFireRequester instance used to request and retrieve data from the datasource.
   *
   * @return returns the {@link DataFireOkHttpRequester} instance.
   */
  public abstract DataFireRequester getRequester();

  /**
   * Return the DataFireMapper instance that maps the data returned from the datasource to the equivalent pojo classes
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

  @PostConstruct
  private void init() {
    work();
  }


  public void work() {

    try {
      String data = getRequester().requestAndGet();

      if (StringUtils.isBlank(data)) {
        log.error("Data cannot be blank");
        return;
      }

      List<T> dataModel = (List<T>) getMapper().mapToModel(data);
      ConcurrentHashMap<CacheKey, T> tempObjCache = getCacheService().getAll();
      getNotifier().updateCacheAndGenerateEvents(dataModel, tempObjCache);

    } catch (Throwable t) {
      log.error("An un-expected error occurred while retrieving objects @[" + new DateTime() + "]", t);
    }

  }
}

