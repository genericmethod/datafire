package com.genericmethod.datafire.samples.producthunt;

import com.genericmethod.datafire.cache.CacheService;
import com.genericmethod.datafire.event.DataFireEvent;
import com.genericmethod.datafire.event.DataFireEventNotifier;
import com.genericmethod.datafire.event.DataFireEventProducer;
import com.genericmethod.datafire.samples.producthunt.enums.ProductHuntEventType;
import com.genericmethod.datafire.samples.producthunt.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProductHuntNewPostEventNotifier extends DataFireEventNotifier<Post,ProductHuntEventType>{

    @Autowired
    private ProductHuntNewPostCacheService productHuntNewPostCacheService;

    @Autowired
    private ProductHuntNewPostEventProducer productHuntEventProducer;


    @Override
    public CacheService getCacheService() {
        return productHuntNewPostCacheService;
    }

    @Override
    public DataFireEventProducer getEventProducer() {
        return productHuntEventProducer;
    }

    @Override
    public List<DataFireEvent<Post, ProductHuntEventType>> getEvent(Post cachedObj, Post feedObject) {

        List<DataFireEvent<Post, ProductHuntEventType>> events = new ArrayList<>();

        if (cachedObj == null && feedObject != null){
            events.add(new DataFireEvent<>(feedObject, ProductHuntEventType.NEW_PRODUCT_ADDED));
        }
        return events;
    }
}
