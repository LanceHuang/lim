package com.lance.lim.mq.kafka.config;

import com.lance.lim.mq.MessagePublisher;
import com.lance.lim.mq.kafka.KafkaMessagePublisher;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * @author Lance
 * @since 2021/4/13
 */
@EnableConfigurationProperties(KafkaPublisherProperties.class)
public class KafkaMessagePublisherConfiguration {

    @Bean
    public KafkaProducer kafkaProducer(KafkaPublisherProperties properties) {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", properties.getServers());
        props.setProperty("key.serializer", properties.getKeySerializer());
        props.setProperty("value.serializer", properties.getValueSerializer());
        return new KafkaProducer<>(props);
    }

    @Bean
    public MessagePublisher messagePublisher() {
        return new KafkaMessagePublisher();
    }
}
