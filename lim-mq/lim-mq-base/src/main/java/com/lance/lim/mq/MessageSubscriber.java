package com.lance.lim.mq;

import java.util.Collection;
import java.util.Set;

/**
 * 消息订阅者
 *
 * @author Lance
 * @since 2021/4/8
 */
public abstract class MessageSubscriber {

    /**
     * 订阅多个主题
     *
     * @param topics 主题
     */
    public abstract void subscribe(Collection<String> topics, PubSub pubSub);

    /**
     * 订阅多个主题
     *
     * @param topic 主题
     */
    public abstract void subscribe(String topic, PubSub pubSub);

    /**
     * 订阅模式
     *
     * @param pattern 模式
     */
    public abstract void subscribePattern(String pattern, PubSub pubSub);

    /**
     * 查询所有订阅的主题
     *
     * @return 所有订阅的主题
     */
    public abstract Set<String> subscription();

    /**
     * 取消订阅
     *
     * @param topic 主题
     */
    public abstract void unsubscribe(String topic);
}
