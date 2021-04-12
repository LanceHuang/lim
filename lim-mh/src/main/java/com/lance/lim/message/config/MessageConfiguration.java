package com.lance.lim.message.config;

import com.lance.lim.mq.redis.config.RedisMessageSubscriberConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 消息处理配置
 *
 * @author Lance
 * @since 2021/4/8
 */
@Configuration
@Import({RedisMessageSubscriberConfiguration.class})
public class MessageConfiguration {
}
