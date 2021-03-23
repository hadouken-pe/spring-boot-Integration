package com.hadouken.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author hadouken-pe@gmail.com
 * @date 2021-03-23 09:53:14
 */
@Configurable
public class RedisCacheConfig {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
}
