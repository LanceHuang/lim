package com.lance.lim.mq.redis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * redis配置
 *
 * @author Lance
 * @since 2021/4/8
 */
@ConfigurationProperties(prefix = "lim.redis")
public class RedisProperties {

    /** 域名 */
    private String host = "localhost";

    /** 端口号 */
    private int port = 6379;

    /** 密码 */
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
