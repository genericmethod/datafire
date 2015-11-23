package com.genericmethod.feedfire.http.interceptor;

import org.apache.http.*;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.io.InputStream;


public class GzipResponseInterceptor implements HttpResponseInterceptor {

    public void process(final HttpResponse response, final HttpContext context) throws HttpException, IOException {
        int size = 0;
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream inputStream = response.getEntity().getContent();
            Header ceheader = entity.getContentEncoding();
            if (ceheader != null) {
                HeaderElement[] codecs = ceheader.getElements();
                for (int i = 0; i < codecs.length; i++) {
                    if (codecs[i].getName().equalsIgnoreCase("gzip")) {
                        GzipDecompressingEntity gz = new GzipDecompressingEntity(new InputStreamEntity(inputStream, size));
                        response.setEntity(gz);
                        return;
                    }
                }
            }
        }
    }
}
