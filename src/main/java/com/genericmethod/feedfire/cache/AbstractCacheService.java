
package com.genericmethod.feedfire.cache;

import com.google.code.ssm.CacheFactory;
import com.google.code.ssm.spring.ExtendedSSMCacheManager;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.impl.KeyIteratorImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This abstract class  handles generic operations related to caching objects from the feed.
 * Extend this class for the ability to save and retrieve objects from the feed being parsed
 * to a specific cache location.
 *
 * @author cfarrugia
 */
public abstract class AbstractCacheService<T extends  CacheableObject> {

    private static Logger log = Logger.getLogger(AbstractCacheService.class);

    private Cache cache;
    private String memcachedIpAddress;
    private Integer memcachedPort;

    @Autowired private ExtendedSSMCacheManager extendedSSMCacheManager;

    /**
     * Returns the cache name
     *
     * @return a String identifying the cache name.
     */
    protected abstract String getFeedCacheName();


    /**
     * The memcached location url to be used to store the cache objects.
     *
     * @return The memcached location url as a String.
     */
    protected abstract String getMemcachedLocation();

    /**
     * Return the {@link com.google.code.ssm.CacheFactory} instance to be used by this cache.
     *
     * @return the cache factory instance
     */
    protected abstract CacheFactory getFeedCacheFactory();

    /**
     * Initializes the cache
     */
    @PostConstruct
    private void initializeCache() throws Exception {

        cache = extendedSSMCacheManager.getCache(getFeedCacheName());
        if (cache == null) {
            throw new Exception("Cache [" + getFeedCacheName() + "] has not been initialized.");
        }

        if (StringUtils.isNotBlank(getMemcachedLocation())) {
            String[] url = getMemcachedLocation().split(":");
            memcachedIpAddress = url[0];
            memcachedPort = Integer.parseInt(url[1]);
        }
    }

    /**
     * Saves an object to the cache.
     *
     * @param obj {@link T} to be saved to cache.
     */
    public void put(CacheKey key, T obj) {
        Validate.notNull(obj, "Null object cannot be put in cache");
        cache.put(key.getCacheKey(), obj);
        log.info("Put object with [" + key + "] to [" + getFeedCacheName() + "] cache.");
    }


    /**
     * Removes an object from the cache
     *
     * @param key - key for object to be removed
     */
    public void remove(CacheKey key) {
        Validate.notBlank(key.getCacheKey(), "The key cannot tbe null");
        cache.evict(key.getCacheKey());
        log.info("Removed object with [" + key + "] to [" + getFeedCacheName() + "] cache.");
    }

    /**
     * Retrieves an object from cache by its cacheKey
     *
     * @param key The key of the object to be retrieved from cache.
     * @return the {@link T} from cache
     * @throws Exception
     */
    public T get(CacheKey key) throws Exception {

        Validate.notNull(key, "CacheKey must be defined when calling get");

        T cachedObj = null;
        Cache.ValueWrapper cacheObject = cache.get(key.getCacheKey());

        if (cacheObject == null) {
            log.warn("Cache Miss :: Object matching key [" + key.getCacheKey() + "] was not found in cache.");
            return cachedObj;
        }

        cachedObj = (T) cacheObject.get();
        log.info("Cache Hit :: Object with id [" + cachedObj.getCacheId() + "] loaded from cache with key [" + key.getCacheKey() + "]");

        return cachedObj;
    }

    public KeyIteratorImpl getAllCacheKeys() {

        KeyIteratorImpl keyIterator = null;

        try {

            log.debug("Retrieving list of keys in cache [" + getFeedCacheName() + "] on [" + memcachedIpAddress + ":" + memcachedPort + "]");
            MemcachedClient client = (MemcachedClient) getFeedCacheFactory().getCache().getNativeClient();
            keyIterator = (KeyIteratorImpl) client.getKeyIterator(new InetSocketAddress(memcachedIpAddress, memcachedPort));

        } catch (Exception exception) {
            log.error("An error occurred while retrieving list of cache keys from ["
                    + getFeedCacheName() + "] on ip [" + memcachedIpAddress + "] and port [" + memcachedPort + "]", exception);
        }

        return keyIterator;
    }


    /***
     * Will return a map of all objects
     *
     * @return
     */
    public ConcurrentHashMap<CacheKey, T> getAll() {

        ConcurrentHashMap<CacheKey, T> objects = new ConcurrentHashMap<CacheKey, T>();

        try {

            KeyIteratorImpl keyIterator = getAllCacheKeys();

            if (keyIterator == null) {
                log.info("No keys found in cache for feed");
                return objects;
            }

            while (keyIterator.hasNext()) {
                final String key = keyIterator.next();
                T obj = get(new CacheKey(key));
                if (obj != null) {
                    objects.put(new CacheKey(key), obj);
                }
            }

            log.info("Found " + objects.size() + " objects in cache");

        } catch (Throwable throwable) {
            log.error("An un-expected error occurred while retrieving list of events for the feed", throwable);
        }

        return objects;
    }

}
