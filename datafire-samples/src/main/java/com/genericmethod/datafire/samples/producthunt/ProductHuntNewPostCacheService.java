package com.genericmethod.datafire.samples.producthunt;

import com.genericmethod.datafire.cache.DataFireInMemoryCacheService;
import com.genericmethod.datafire.samples.producthunt.model.Post;
import org.springframework.stereotype.Component;

@Component
public class ProductHuntNewPostCacheService extends DataFireInMemoryCacheService<Post>{
}
