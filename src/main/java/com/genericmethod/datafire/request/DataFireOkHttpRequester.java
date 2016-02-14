package com.genericmethod.datafire.request;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import javax.annotation.PostConstruct;

;

/**
 * Requests and retrieves data by connectiing the data endpoint represented as an {@link HttpUrl}
 */
public abstract class DataFireOkHttpRequester implements DataFireRequester {

  private static Logger log = Logger.getLogger(DataFireOkHttpRequester.class);

  @PostConstruct
  public void afterPropertiesSet() throws Exception {
  }

  /**
   * Return the url of the feed to download
   *
   * @return the xml feed url
   */
  public abstract HttpUrl getDataEndpointUrl();

  /**
   * Uses {@link OkHttpClient} to connect to the data endpoint and retrieve data.
   */
  public String requestAndGet() throws Exception {

    OkHttpClient httpClient = new OkHttpClient();

    int retry = 0;
    String data = null;
    Request request = new Request.Builder().url(getDataEndpointUrl()).build();
    Response response = httpClient.newCall(request).execute();
    data = response.body().string();
    log.debug("Data retrieved at attempt [" + retry + "] [" + getDataEndpointUrl() + "] at [" + new DateTime() + "]");
    return data;
  }

}
