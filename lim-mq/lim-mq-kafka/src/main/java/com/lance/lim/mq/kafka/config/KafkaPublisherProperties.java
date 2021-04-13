package com.lance.lim.mq.kafka.config;

import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * kafka发布者配置
 *
 * @author Lance
 * @since 2021/4/13
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "lim.kafka.pub")
public class KafkaPublisherProperties {

    private String servers;

    private String keySerializer = StringSerializer.class.getName();

    private String valueSerializer = StringSerializer.class.getName();
}
