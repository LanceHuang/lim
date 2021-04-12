package com.lance.lim.mq.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author Lance
 * @since 2021/4/12
 */
@SpringBootTest(classes = RedisTest.Config.class)
public class RedisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void test() {
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @SpringBootApplication
    public static class Config {
    }
}
