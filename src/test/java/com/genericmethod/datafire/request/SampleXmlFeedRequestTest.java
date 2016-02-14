package com.genericmethod.datafire.request;


import com.genericmethod.datafire.sample.SampleFeedRequester;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SampleXmlFeedRequestTest {

  public static final String XML_RESPONSE = "<xml>\n"
          + "    <element></element>\n"
          + "    <element></element>\n"
          + "</xml>";

  @Spy
  SampleFeedRequester feedRequester;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testRequestAndGet() throws Exception {

    MockWebServer server = new MockWebServer();
    server.enqueue(new MockResponse().setBody(XML_RESPONSE));
    server.start();

    HttpUrl baseUrl = server.url("/v1/feed/");
    when(feedRequester.getDataEndpointUrl()).thenReturn(baseUrl);

    assertEquals(XML_RESPONSE, feedRequester.requestAndGet());

  }
}
