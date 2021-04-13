package com.lance.lim.mq.kafka.config;

import com.lance.lim.mq.MessageSubscriber;
import com.lance.lim.mq.kafka.KafkaMessageSubscriber;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * @author Lance
 * @since 2021/4/13
 */
@EnableConfigurationProperties(KafkaSubscriberProperties.class)
public class KafkaMessageSubscriberConfiguration {

    @Bean
    public KafkaConsumer kafkaConsumer(KafkaSubscriberProperties properties) {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", properties.getServers());
        props.setProperty("key.deserializer", properties.getKeyDeserializer());
        props.setProperty("value.deserializer", properties.getValueDeserializer());
        props.setProperty("group.id", properties.getGroupId());
        return new KafkaConsumer(props);
    }

    @Bean
    public MessageSubscriber messageSubscriber() {
        return new KafkaMessageSubscriber();
    }
}
