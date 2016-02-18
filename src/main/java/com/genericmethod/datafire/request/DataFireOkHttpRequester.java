package com.genericmethod.datafire.request;

import com.squareup.okhttp.*;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import javax.annotation.PostConstruct;

;

/**
 * Requests and retrieves data by connecting the data endpoint represented as an {@link HttpUrl}
 */
public abstract class DataFireOkHttpRequester implements DataFireRequester {

  private static Logger log = Logger.getLogger(DataFireOkHttpRequester.class);

  @PostConstruct
  public void afterPropertiesSet() throws Exception {
  }

  /**
   * Return the url of the data source
   *
   * @return the data endpoint url
   */
  public abstract HttpUrl getDataEndpointUrl();

  /**
   * Define any headers needed to execute request.
   * @return {@link Headers}
   */
  public abstract Headers getHeaders();

  /**
   * Uses {@link OkHttpClient} to connect to the data endpoint and retrieve data.
   */
  public String requestAndGet() throws Exception {

    OkHttpClient httpClient = new OkHttpClient();

    int retry = 0;
    String data = null;
    Request request = new Request.Builder().url(getDataEndpointUrl()).headers(getHeaders()).build();
    Response response = httpClient.newCall(request).execute();
    data = response.body().string();
    log.debug("Data retrieved at attempt [" + retry + "] [" + getDataEndpointUrl() + "] at [" + new DateTime() + "]");
    return data;
  }

}
