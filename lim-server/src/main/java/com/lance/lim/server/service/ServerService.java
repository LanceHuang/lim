package com.lance.lim.server.service;

import com.lance.lim.mq.MessagePublisher;
import com.lance.lim.server.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Lance
 * @since 2021/4/8
 */
@Component
public class ServerService implements IServerService {

    @Autowired
    private MessagePublisher messagePublisher;

    @Override
    public void sendMessage(String userId, ChatMessage chatMsg) {
        // 按会话、群号取模，将消息发布到不同的topic


        // 回执
    }
}
