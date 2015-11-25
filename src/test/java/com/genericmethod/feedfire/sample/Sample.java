package com.genericmethod.feedfire.sample;

import com.genericmethod.feedfire.cache.CacheableObject;

/**
 * @author cfarrugia
 */
public class Sample extends CacheableObject {

    @Override
    public String getCacheId() {
        return null;
    }
}
