package com.lance.lim.client.config;

import com.lance.lim.client.Client;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
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

    @Bean
    public Client client(ClientProperties clientProperties) {
        return new Client(clientProperties);
    }
}
