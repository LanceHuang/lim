package com.lance.lim.client.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 客户端配置
 *
 * @author Lance
 * @since 2021/4/11
 */
@Configuration
@EnableConfigurationProperties(ClientProperties.class)
public class ClientConfiguration {
}
