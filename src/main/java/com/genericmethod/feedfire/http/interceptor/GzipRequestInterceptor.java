package com.genericmethod.feedfire.http.interceptor;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;


public class GzipRequestInterceptor implements HttpRequestInterceptor {

    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        Header[] requestHeaders = request.getHeaders("Accept-Encoding");
        boolean gzipEnabled = false;
        for (Header requestHeader : requestHeaders) {
            if (requestHeader.getValue().contains("gzip")) {
                gzipEnabled = true;
                break;
            }
        }
        if (!gzipEnabled)
            request.addHeader("Accept-Encoding", "gzip,deflate");
    }
}
