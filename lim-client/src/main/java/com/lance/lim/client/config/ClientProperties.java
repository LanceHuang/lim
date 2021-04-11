package com.lance.lim.client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 客户端配置
 *
 * @author Lance
 * @since 2021/4/11
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "lim.client")
public class ClientProperties {
}
