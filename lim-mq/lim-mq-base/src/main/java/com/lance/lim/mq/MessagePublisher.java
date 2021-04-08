package com.lance.lim.mq;

import com.lance.lim.mq.model.Message;

/**
 * 消息发布者
 *
 * @author Lance
 * @since 2021/4/8
 */
public abstract class MessagePublisher {

    /**
     * 发布消息
     *
     * @param topic   主题
     * @param message 消息
     */
    public abstract void publish(String topic, Message message);
}
