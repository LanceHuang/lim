package com.lance.lim.mq;

import com.lance.lim.mq.model.Message;

/**
 * @author Lance
 * @since 2021/4/8
 */
public abstract class PubSub {

    public abstract void onMessage(String topic, Message message);
}
