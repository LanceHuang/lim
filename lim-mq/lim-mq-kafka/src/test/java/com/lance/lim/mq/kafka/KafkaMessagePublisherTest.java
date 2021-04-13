package com.lance.lim.mq.kafka;

import com.lance.lim.mq.MessagePublisher;
import com.lance.lim.mq.kafka.config.KafkaMessagePublisherConfiguration;
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
@SpringBootTest(classes = KafkaMessagePublisherTest.Config.class)
public class KafkaMessagePublisherTest {

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
    @Import({KafkaMessagePublisherConfiguration.class})
    public static class Config {
    }
}