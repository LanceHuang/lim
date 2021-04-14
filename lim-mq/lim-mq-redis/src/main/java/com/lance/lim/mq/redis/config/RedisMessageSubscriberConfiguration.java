package com.lance.lim.mq.redis.config;

import com.lance.lim.mq.MessageSubscriber;
import com.lance.lim.mq.redis.RedisMessageSubscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * 消息订阅者配置
 *
 * @author Lance
 * @since 2021/4/8
 */
public class RedisMessageSubscriberConfiguration {

    @Bean
    public MessageSubscriber messageSubscriber() {
        return new RedisMessageSubscriber();
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisTemplate redisTemplate) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisTemplate.getConnectionFactory());
        return container;
    }
}
