package com.lance.lim.server;

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
        // 投递


        // 回执
    }


}
