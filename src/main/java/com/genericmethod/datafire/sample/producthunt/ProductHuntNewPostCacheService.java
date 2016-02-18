package com.genericmethod.datafire.sample.producthunt;

import com.genericmethod.datafire.cache.DataFireInMemoryCacheService;
import com.genericmethod.datafire.sample.producthunt.model.Post;
import org.springframework.stereotype.Component;

@Component
public class ProductHuntNewPostCacheService extends DataFireInMemoryCacheService<Post>{
}
