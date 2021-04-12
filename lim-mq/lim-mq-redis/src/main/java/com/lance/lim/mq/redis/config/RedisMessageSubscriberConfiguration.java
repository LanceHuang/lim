package com.lance.lim.mq.redis.config;

import com.lance.lim.common.config.RedisProperties;
import com.lance.lim.mq.MessageSubscriber;
import com.lance.lim.mq.redis.RedisMessageSubscriber;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 消息订阅者配置
 *
 * @author Lance
 * @since 2021/4/8
 */
@EnableConfigurationProperties(RedisProperties.class)
public class RedisMessageSubscriberConfiguration {

    @Bean
    public MessageSubscriber messageSubscriber(RedisProperties redisProperties) {
        return new RedisMessageSubscriber(redisProperties);
    }
}
