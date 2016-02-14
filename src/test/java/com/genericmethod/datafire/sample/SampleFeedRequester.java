package com.genericmethod.datafire.sample;

import com.genericmethod.datafire.request.DataFireOkHttpRequester;
import com.squareup.okhttp.HttpUrl;
import org.springframework.stereotype.Component;

@Component
public class SampleFeedRequester extends DataFireOkHttpRequester {

  @Override
  public HttpUrl getDataEndpointUrl() {
    return new HttpUrl.Builder()
            .scheme("http")
            .host("localhost")
            .port(8080)
            .addPathSegment("v1")
            .addPathSegment("feed")
            .build();
  }
}
