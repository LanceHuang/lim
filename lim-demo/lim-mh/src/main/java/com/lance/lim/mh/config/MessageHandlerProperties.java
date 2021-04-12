package com.lance.lim.mh.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 消息处理器配置
 *
 * @author Lance
 * @since 2021/4/12
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "lim.mh")
public class MessageHandlerProperties {

    /** 消息队列主题 */
    private String topic;
}
