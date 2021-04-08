package com.lance.lim.mq;

/**
 * 消息订阅者
 *
 * @author Lance
 * @since 2021/4/8
 */
public abstract class MessageSubscriber {

    /**
     * 订阅主题
     *
     * @param topics 主题列表
     */
    public abstract void subscribe(PubSub pubSub, String... topics);
}
