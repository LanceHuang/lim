package com.lance.lim.mq.redis.config;

import com.lance.lim.mq.MessagePublisher;
import com.lance.lim.mq.redis.RedisMessagePublisher;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 消息发布者配置
 *
 * @author Lance
 * @since 2021/4/8
 */
@EnableConfigurationProperties(RedisProperties.class)
public class RedisMessagePublisherAutoConfiguration {

    @Bean
    public MessagePublisher messagePublisher(RedisProperties redisProperties) {
        return new RedisMessagePublisher(redisProperties);
    }
}
