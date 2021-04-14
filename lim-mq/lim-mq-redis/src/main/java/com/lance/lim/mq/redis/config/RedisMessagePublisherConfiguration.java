package com.lance.lim.mq.redis.config;

import com.lance.lim.mq.MessagePublisher;
import com.lance.lim.mq.redis.RedisMessagePublisher;
import org.springframework.context.annotation.Bean;

/**
 * 消息发布者配置
 *
 * @author Lance
 * @since 2021/4/8
 */
public class RedisMessagePublisherConfiguration {

    @Bean
    public MessagePublisher messagePublisher() {
        return new RedisMessagePublisher();
    }
}
