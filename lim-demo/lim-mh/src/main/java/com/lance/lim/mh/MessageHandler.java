package com.lance.lim.mh;

import com.lance.lim.common.util.AbstractLifecycle;
import com.lance.lim.mh.config.MessageHandlerProperties;
import com.lance.lim.mq.MessageSubscriber;
import lombok.extern.slf4j.Slf4j;

/**
 * 消息处理器
 *
 * @author Lance
 * @since 2021/4/12
 */
@Slf4j
public class MessageHandler extends AbstractLifecycle {

    private MessageSubscriber messageSubscriber;

    private MessageHandlerProperties messageHandlerProperties;

    private Runnable runner;

    public MessageHandler(MessageSubscriber messageSubscriber, MessageHandlerProperties messageHandlerProperties) {
        this.messageSubscriber = messageSubscriber;
        this.messageHandlerProperties = messageHandlerProperties;
    }

    @Override
    public void doStart() {
        this.runner = () -> {
            // todo
            messageSubscriber.subscribe(messageHandlerProperties.getTopic(), null);
        };
        new Thread(runner).start();
    }

    @Override
    public void doStop() {
    }
}
