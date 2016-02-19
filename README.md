[![Build Status](https://travis-ci.org/genericmethod/datafire.svg?branch=master)](https://travis-ci.org/genericmethod/datafire)
[![Coverage Status](https://coveralls.io/repos/genericmethod/feed-fire/badge.svg?branch=master&service=github)](https://coveralls.io/github/genericmethod/datafiree?branch=master)

[![dsf](http://emojipedia-us.s3.amazonaws.com/cache/67/78/6778e5687df78a4ee0c2e54c759b0a4a.png)]

# Data Fire
Data Fire is a tiny framework that helps developers represent a rapidly changing datasource as events.

# How does it work?

Given a changing data source DataFire will emit data changes as events by

1. Requesting data from the datasource (JSON, XML CSV)
2. Mapping this data to the equivalent POJO objects
3. Comparing the objects to their previous cached version to generate a custom event.
4. Publish/Store the event to any endpoint - webhook, jms, db
5. Repeat the above, again and again.


# How To Use

Start by including the following repository and dependency in your pom.xml

```
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.genericmethod</groupId>
    <artifactId>datafire</artifactId>
    <version>1.0.1-alpha</version>
</dependency>
```

In the following example we will be implementing a few classes to monitor new posts on Product hunt and expose them as events.

- DataFireOkHttpRequester - handles data retrieval from datasource over http
- DataFireMapper - handles data mapping to POJO
- DataFireEventNotifier - handles event generation
- DataFireEventProducer - handles event publishing
- DataFireCacheService  - handles POJO caching
- DateFireRequestScheduler - handles data polling

Lets explain how this is done :

First implement an instance of DataFireOkHttpRequester

```

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
                .add("Authorization","Bearer replace with access_token)
                .add("Content-Type", "application/json")
                .add("Accept", "application/json")
                .add("Host", "api.producthunt.com")
                .build();

    }
}

```

Then implement an instance of DataFireMapper. Pojo's need to be created in order to map the response string received from Product Hunt

```
@Component
public class ProductHuntNewPostsMapper extends DataFireMapper<Post>{

    @Override
    public List<Post> mapToModel(String s) throws DataFireException {

        ObjectMapper mapper = new ObjectMapper();
        ProductHuntNewPostData newPostList;

        try {
             newPostList  = mapper.readValue(s, ProductHuntNewPostData.class);
        } catch (IOException e) {
            throw new DataFireException("Could not map data");
        }

        return newPostList.getPosts();
    }
}
```

DataFireEventNotifier - this is where we will create our events based on the data
In this case, if DataFire does not have the Post received from Product Hunt in cache,
then a NEW_PRODUCT_ADDED created.

```
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
```

Defining a DataFireEventProducer gives us the capability of sending the event to any other endpoint

```java
@Component
public class ProductHuntNewPostEventProducer extends DataFireEventProducer<Post,ProductHuntEventType>{

    @Override
    public void sendEvent(List<DataFireEvent<Post, ProductHuntEventType>> events) {
        for (DataFireEvent<Post, ProductHuntEventType> event : events) {
            System.out.println(event.getMessage().getName() + " " + event.getEventType().name());
        }
    }
}

```

DataFireInMemoryCacheService defines the object that will be cached. In this case the Post object is cached.
Note that the Post object should extend CacheableObject and implement the getCacheId() method.
The getCacheId method is used internally as the cache key.

```
@Component
public class ProductHuntNewPostCacheService extends DataFireInMemoryCacheService<Post>{
}

```

By implementing the DateFireRequestScheduler we define all the components that are required to
poll the datasource, cache data and produce events.

```
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
```

Finally, configure the scheduling task that will poll the datasource

```
 @Configuration
 public class ProductHuntSchedulerConfig extends DataFireSchedulerConfig {

     @Autowired
     ProductHuntNewPostRequestScheduler productHuntNewPostRequestScheduler;

     @Override
     public DataFireRequestScheduler myTask() {
         return productHuntNewPostRequestScheduler;
     }

     @Override
     public Trigger getTrigger() {
         return new PeriodicTrigger(10000);
     }
 }
```

#Version

- Version 1.0.1-alpha


# Status
Work in Progress.



