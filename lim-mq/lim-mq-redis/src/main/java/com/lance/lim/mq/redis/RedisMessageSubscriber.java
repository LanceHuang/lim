package com.lance.lim.mq.redis;

import com.lance.lim.common.util.JsonUtils;
import com.lance.lim.mq.MessageSubscriber;
import com.lance.lim.mq.PubSub;
import com.lance.lim.mq.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis消息订阅者
 *
 * @author Lance
 * @since 2021/4/8
 */
public class RedisMessageSubscriber extends MessageSubscriber {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void subscribe(PubSub pubSub, String... topics) {
//        jedis.subscribe(new JedisPubSub() {
//            @Override
//            public void onMessage(String channel, String message) {
//                // todo 格式校验
//                pubSub.onMessage(channel, JsonUtils.json2object(message, Message.class));
//            }
//        }, topics);
    }
}
