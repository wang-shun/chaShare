package com.holley.platform.service;

public interface CacheService {

    Object getRedisCache(String key);

    void setRedisCache(String key, Object value);

    void removeRedisCache(String key);

}
