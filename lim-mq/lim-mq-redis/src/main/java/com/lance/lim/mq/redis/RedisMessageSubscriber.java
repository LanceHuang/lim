package com.lance.lim.mq.redis;

import com.lance.lim.common.util.JsonUtils;
import com.lance.lim.mq.MessageSubscriber;
import com.lance.lim.mq.PubSub;
import com.lance.lim.mq.model.Message;
import com.lance.lim.mq.redis.config.RedisProperties;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * redis消息订阅者
 *
 * @author Lance
 * @since 2021/4/8
 */
public class RedisMessageSubscriber extends MessageSubscriber {

    private Jedis jedis;

    public RedisMessageSubscriber(RedisProperties redisProperties) {
        jedis = new Jedis(redisProperties.getHost(), redisProperties.getPort());
    }

    @Override
    public void subscribe(PubSub pubSub, String... topics) {
        jedis.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                pubSub.onMessage(channel, JsonUtils.json2object(message, Message.class));
            }
        }, topics);
    }
}
