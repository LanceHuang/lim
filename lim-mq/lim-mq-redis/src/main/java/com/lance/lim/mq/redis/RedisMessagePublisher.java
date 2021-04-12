package com.lance.lim.mq.redis;

import com.lance.lim.mq.MessagePublisher;
import com.lance.lim.mq.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis消息发布者
 *
 * @author Lance
 * @since 2021/4/8
 */
public class RedisMessagePublisher extends MessagePublisher {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void publish(String topic, Message message) {
        redisTemplate.convertAndSend(topic, message);
    }
}
