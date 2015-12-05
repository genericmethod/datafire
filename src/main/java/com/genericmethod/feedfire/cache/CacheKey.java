package com.genericmethod.feedfire.cache;

public class CacheKey {

  private final String cacheKey;

  public String getCacheKey() {
    return cacheKey;
  }

  public CacheKey(String cacheKey) {
    this.cacheKey = cacheKey;
  }

  @Override
  public boolean equals(Object obj) {

    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final CacheKey other = (CacheKey) obj;

    return !((this.cacheKey == null) ? (other.cacheKey != null) : !this.cacheKey.equals(other.cacheKey));
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 53 * hash + (this.cacheKey != null ? this.cacheKey.hashCode() : 0);
    return hash;
  }
}
