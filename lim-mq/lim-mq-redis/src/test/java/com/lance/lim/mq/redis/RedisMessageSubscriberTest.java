package com.lance.lim.mq.redis;

import com.lance.lim.mq.MessageSubscriber;
import com.lance.lim.mq.PubSub;
import com.lance.lim.mq.model.Message;
import com.lance.lim.mq.redis.config.RedisMessagePublisherConfiguration;
import com.lance.lim.mq.redis.config.RedisMessageSubscriberConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * @author Lance
 * @since 2021/4/8
 */
@SpringBootTest(classes = RedisMessageSubscriberTest.Config.class)
public class RedisMessageSubscriberTest {

    private static final String TOPIC = "test";

    @Autowired
    private MessageSubscriber messageSubscriber;

    @Test
    public void test() throws InterruptedException {
        messageSubscriber.subscribe(new PubSub() {
            @Override
            public void onMessage(String topic, Message message) {
                System.out.println("订阅" + topic + "主题的消息：" + message);
            }
        }, TOPIC);

        // 等待消息
        Thread.sleep(30000L);
    }

    @SpringBootApplication
    @Import(RedisMessageSubscriberConfiguration.class)
    public static class Config {
    }
}