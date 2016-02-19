package com.genericmethod.datafire.request;

import com.squareup.okhttp.Headers;
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

    @Override
    public Headers getHeaders() {
        return new Headers.Builder().build();
    }
}
