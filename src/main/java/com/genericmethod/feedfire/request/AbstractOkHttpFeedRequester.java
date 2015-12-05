package com.genericmethod.feedfire.request;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
;

import javax.annotation.PostConstruct;

/**
 * Requests and downloads an xml feed. If request fails, retries a number of times specified by
 * getMaximumRetry()
 */
public abstract class AbstractOkHttpFeedRequester implements FeedRequester {

  private static Logger log = Logger.getLogger(AbstractOkHttpFeedRequester.class);

  @PostConstruct
  public void afterPropertiesSet() throws Exception {
  }

  /**
   * Return the url of the feed to download
   *
   * @return the xml feed url
   */
  public abstract HttpUrl getFeedUrl();

  /**
   * Uses OkHttpClient to download an xml file.
   */
  public String requestAndGet() throws Exception {

    OkHttpClient httpClient = new OkHttpClient();

    int retry = 0;
    String xmlFeed = null;
    Request request = new Request.Builder().url(getFeedUrl()).build();
    Response response = httpClient.newCall(request).execute();
    xmlFeed = response.body().string();
    log.debug("Xml feed retrieved at attempt [" + retry + "] [" + getFeedUrl() + "] at [" + new DateTime() + "]");
    return xmlFeed;
  }

}
