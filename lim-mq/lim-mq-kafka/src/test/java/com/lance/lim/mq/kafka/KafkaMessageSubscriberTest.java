package com.lance.lim.mq.kafka;

import com.lance.lim.mq.MessageSubscriber;
import com.lance.lim.mq.PubSub;
import com.lance.lim.mq.kafka.config.KafkaMessageSubscriberConfiguration;
import com.lance.lim.mq.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * @author Lance
 * @since 2021/4/13
 */
@SpringBootTest(classes = KafkaMessageSubscriberTest.Config.class)
public class KafkaMessageSubscriberTest {

    private static final String TOPIC = "test";

    @Autowired
    private MessageSubscriber messageSubscriber;

    @Test
    public void test() {
        messageSubscriber.subscribe(new PubSub() {
            @Override
            public void onMessage(String topic, Message message) {
                System.out.println("订阅" + topic + "主题的消息：" + message);
            }
        }, TOPIC);
    }

    @SpringBootApplication
    @Import({KafkaMessageSubscriberConfiguration.class})
    public static class Config {
    }
}