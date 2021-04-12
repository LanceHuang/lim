package com.lance.lim.mh;

import com.lance.lim.common.util.AbstractLifecycle;
import com.lance.lim.mh.config.MessageHandlerProperties;
import lombok.extern.slf4j.Slf4j;

/**
 * 消息处理器
 *
 * @author Lance
 * @since 2021/4/12
 */
@Slf4j
public class MessageHandler extends AbstractLifecycle {

    private MessageHandlerProperties messageHandlerProperties;

    public MessageHandler(MessageHandlerProperties messageHandlerProperties) {
        this.messageHandlerProperties = messageHandlerProperties;
    }

    @Override
    public void doStart() {
        // todo
    }

    @Override
    protected void doStop() {
        // todo
    }
}
