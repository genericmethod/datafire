package com.genericmethod.feedfire.cache;

/**
 * @author cfarrugia
 */
public class CacheKey {

    private final String cacheKey;

    public String getCacheKey(){
         return cacheKey;
    };

    public CacheKey(String cacheKey){
        this.cacheKey = cacheKey;
    }
}
