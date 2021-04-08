package com.lance.lim.server.config;

import com.lance.lim.mq.redis.config.RedisMessagePublisherConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 消息服配置
 *
 * @author Lance
 * @since 2021/4/8
 */
@Configuration
@Import({RedisMessagePublisherConfiguration.class})
public class ServerConfiguration {
}
