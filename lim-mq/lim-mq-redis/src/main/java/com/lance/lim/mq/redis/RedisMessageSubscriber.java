package com.lance.lim.mq.redis;

import com.lance.lim.common.util.JsonUtils;
import com.lance.lim.mq.MessageSubscriber;
import com.lance.lim.mq.PubSub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * redis消息订阅者
 *
 * @author Lance
 * @since 2021/4/8
 */
public class RedisMessageSubscriber extends MessageSubscriber {

    @Autowired
    private RedisMessageListenerContainer redisMessageListenerContainer;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void subscribe(Collection<String> topics, PubSub pubSub) {
        redisMessageListenerContainer.addMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] pattern) {
                String key = deserialize(pattern);
                String msg = deserialize(message.getBody());
                pubSub.onMessage(key, JsonUtils.json2object(msg, com.lance.lim.mq.model.Message.class));
            }
        }, of(topics));
    }

    @Override
    public void subscribe(String topic, PubSub pubSub) {
        redisMessageListenerContainer.addMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] pattern) {
                String key = deserialize(pattern);
                String msg = deserialize(message.getBody());
                pubSub.onMessage(key, JsonUtils.json2object(msg, com.lance.lim.mq.model.Message.class));
            }
        }, ChannelTopic.of(topic));
    }

    @Override
    public void subscribePattern(String pattern, PubSub pubSub) {
        redisMessageListenerContainer.addMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] pattern) {
                String key = deserialize(pattern);
                String msg = deserialize(message.getBody());
                pubSub.onMessage(key, JsonUtils.json2object(msg, com.lance.lim.mq.model.Message.class));
            }
        }, PatternTopic.of(pattern));
    }

    @Override
    public Set<String> subscription() {
        return null;
    }

    @Override
    public void unsubscribe(String topic) {

    }

    private Collection<Topic> of(Collection<String> topics) {
        List<Topic> topicList = new ArrayList<>(topics.size());
        for (String topic : topics) {
            topicList.add(ChannelTopic.of(topic));
        }
        return topicList;
    }

    @SuppressWarnings("unchecked")
    private <T> T deserialize(byte[] data) {
        return (T) redisTemplate.getValueSerializer().deserialize(data);
    }
}
