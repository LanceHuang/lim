package com.lance.lim.mq.redis;

import com.lance.lim.common.util.JsonUtils;
import com.lance.lim.mq.MessagePublisher;
import com.lance.lim.mq.model.Message;
import com.lance.lim.mq.redis.config.RedisProperties;
import redis.clients.jedis.Jedis;

/**
 * redis消息发布者
 *
 * @author Lance
 * @since 2021/4/8
 */
public class RedisMessagePublisher extends MessagePublisher {

    private Jedis jedis;

    public RedisMessagePublisher(RedisProperties redisProperties) {
        jedis = new Jedis(redisProperties.getHost(), redisProperties.getPort());
    }

    @Override
    public void publish(String topic, Message message) {
        jedis.publish(topic, JsonUtils.object2json(message));
    }
}
