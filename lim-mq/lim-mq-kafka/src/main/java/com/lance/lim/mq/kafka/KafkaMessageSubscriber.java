package com.lance.lim.mq.kafka;

import com.lance.lim.mq.MessageSubscriber;
import com.lance.lim.mq.PubSub;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;

/**
 * kafka消息订阅者
 *
 * @author Lance
 * @since 2021/4/13
 */
public class KafkaMessageSubscriber extends MessageSubscriber {

    @Autowired
    private KafkaConsumer kafkaConsumer;

    @Override
    public void subscribe(Collection<String> topics, PubSub pubSub) {

    }

    @Override
    public void subscribe(String topic, PubSub pubSub) {

    }

    @Override
    public void subscribePattern(String pattern, PubSub pubSub) {

    }

    @Override
    public Set<String> subscription() {
        return null;
    }

    @Override
    public void unsubscribe(String topic) {

    }
}
