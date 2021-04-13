package com.lance.lim.mq.kafka.config;

import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * kafka订阅者配置
 *
 * @author Lance
 * @since 2021/4/13
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "lim.kafka.sub")
public class KafkaSubscriberProperties {

    private String servers;

    private String keyDeserializer = StringDeserializer.class.getName();

    private String valueDeserializer = StringDeserializer.class.getName();

    /** 订阅者组id */
    private String groupId;
}
