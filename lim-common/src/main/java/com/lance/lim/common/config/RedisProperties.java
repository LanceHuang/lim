package com.lance.lim.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * redis配置
 *
 * @author Lance
 * @since 2021/4/8
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "lim.redis")
public class RedisProperties {

    /** 域名 */
    private String host;

    /** 端口号 */
    private int port;

    /** 密码 */
    private String password;
}
