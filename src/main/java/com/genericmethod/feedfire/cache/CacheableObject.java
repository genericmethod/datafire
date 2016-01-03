package com.genericmethod.feedfire.cache;

import java.io.Serializable;


public abstract class CacheableObject implements Serializable {
  public abstract String getCacheId();
}
