package com.lance.lim.mh.config;

import com.lance.lim.mh.MessageHandler;
import com.lance.lim.mq.MessageSubscriber;
import com.lance.lim.mq.redis.config.RedisMessageSubscriberConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 消息处理器配置
 *
 * @author Lance
 * @since 2021/4/8
 */
@Configuration
@Import({RedisMessageSubscriberConfiguration.class})
@EnableConfigurationProperties(MessageHandlerProperties.class)
public class MessageHandlerConfiguration {

    @Bean
    public MessageHandler messageHandlerBean(MessageSubscriber messageSubscriber, MessageHandlerProperties messageHandlerProperties) {
        return new MessageHandler(messageSubscriber, messageHandlerProperties);
    }
}
