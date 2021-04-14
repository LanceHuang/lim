package com.lance.lim.mq.redis;

import com.lance.lim.mq.MessagePublisher;
import com.lance.lim.mq.model.Message;
import com.lance.lim.mq.redis.config.RedisMessagePublisherConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * @author Lance
 * @since 2021/4/8
 */
@SpringBootTest(classes = RedisMessagePublisherTest.Config.class)
public class RedisMessagePublisherTest {

    private static final String TOPIC = "test";

    @Autowired
    private MessagePublisher messagePublisher;

    @Test
    public void test() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setContent("你好，我是某某某");
        message.setClientTimestamp(System.currentTimeMillis());
        message.setSender("Lance");
        message.setReceiver("Alice");
        message.setServerTimestamp(System.currentTimeMillis());
        messagePublisher.publish(TOPIC, message);
    }

    @SpringBootApplication
    @Import(RedisMessagePublisherConfiguration.class)
    public static class Config {
    }
}