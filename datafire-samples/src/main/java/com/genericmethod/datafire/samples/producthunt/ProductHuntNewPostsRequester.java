package com.genericmethod.datafire.samples.producthunt;

import com.genericmethod.datafire.request.DataFireOkHttpRequester;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.HttpUrl;
import org.springframework.stereotype.Component;


@Component
public class ProductHuntNewPostsRequester extends DataFireOkHttpRequester {

    @Override
    public HttpUrl getDataEndpointUrl() {

        /**
         https://api.producthunt.com/v1/
         GET /v1/posts/all
         Accept: application/json
         Content-Type: application/json
         Authorization: Bearer your_access_token
         Host: api.producthunt.com
         */
        return new HttpUrl.Builder()
                .scheme("https")
                .host("api.producthunt.com")
                .addPathSegment("v1")
                .addPathSegment("posts")
                .addPathSegment("all")
                .build();
    }

    @Override
    public Headers getHeaders() {
       return new Headers.Builder()
                .add("Authorization","Bearer a8eed30adec19b41f7933f32f55e5ccc4eb9d087b1ddfef6383b545f546c7ba3")
                .add("Content-Type", "application/json")
                .add("Accept", "application/json")
                .add("Host", "api.producthunt.com")
                .build();

    }
}
