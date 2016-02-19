package com.genericmethod.datafire.samples.producthunt;

import com.genericmethod.datafire.cache.CacheService;
import com.genericmethod.datafire.cache.DataFireInMemoryCacheService;
import com.genericmethod.datafire.event.DataFireEventNotifier;
import com.genericmethod.datafire.mapper.DataFireMapper;
import com.genericmethod.datafire.request.DataFireRequestScheduler;
import com.genericmethod.datafire.request.DataFireRequester;
import com.genericmethod.datafire.samples.producthunt.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductHuntNewPostRequestScheduler extends DataFireRequestScheduler<Post> {

    @Autowired
    private ProductHuntNewPostsRequester requester;

    @Autowired
    private ProductHuntNewPostsMapper mapper;

    @Autowired
    private DataFireInMemoryCacheService<Post> cacheService;

    @Autowired
    private ProductHuntNewPostEventNotifier notifier;

    @Override
    public DataFireRequester getRequester() {
        return requester;
    }

    @Override
    public DataFireMapper getMapper() {
        return mapper;
    }

    @Override
    public CacheService getCacheService() {
        return cacheService;
    }

    @Override
    public DataFireEventNotifier getNotifier() {
        return notifier;
    }

}
