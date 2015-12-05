package com.genericmethod.feedfire.request;


import com.genericmethod.feedfire.exception.FeedFireException;
import com.genericmethod.feedfire.sample.SampleFeedRequester;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SampleXmlFeedRequestTest {

  public static final String xmlResponse = "<xml>\n" +
          "    <element></element>\n" +
          "    <element></element>\n" +
          "</xml>";

  @Spy
  SampleFeedRequester feedRequester;

  @Before
  public void setup(){
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testRequestAndGet() throws Exception {

    MockWebServer server = new MockWebServer();
    server.enqueue(new MockResponse().setBody(xmlResponse));
    server.start();

    HttpUrl baseUrl = server.url("/v1/feed/");
    when(feedRequester.getFeedUrl()).thenReturn(baseUrl);

    assertEquals(xmlResponse, feedRequester.requestAndGet());

  }
}
