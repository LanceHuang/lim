package com.lance.lim.mq.redis;

import com.lance.lim.mq.MessagePublisher;
import com.lance.lim.mq.model.Message;
import com.lance.lim.mq.redis.config.RedisMessagePublisherAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Lance
 * @since 2021/4/8
 */
@SpringBootTest(classes = RedisMessagePublisherAutoConfiguration.class)
public class RedisMessagePublisherTest {

    private static final String TOPIC = "test";

    @Autowired
    private MessagePublisher messagePublisher;

    @Test
    public void test() {
        messagePublisher.publish(TOPIC, new Message());
    }
}