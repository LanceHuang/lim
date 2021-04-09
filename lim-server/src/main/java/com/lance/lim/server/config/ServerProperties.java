package com.lance.lim.server.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 消息服配置
 *
 * @author Lance
 * @since 2021/4/9
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "lim.server")
public class ServerProperties {

    /** 服id */
    private int id;

    /** 端口号 */
    private int port;

    // todo max size
}
