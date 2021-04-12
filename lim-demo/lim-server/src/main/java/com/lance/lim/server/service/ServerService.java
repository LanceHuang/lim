package com.lance.lim.server.service;

import com.lance.lim.core.message.RespChatMessage;
import com.lance.lim.mq.MessagePublisher;
import com.lance.lim.core.message.ReqChatMessage;
import com.lance.lim.mq.model.Message;
import com.lance.lim.server.config.ServerProperties;
import com.lance.lim.server.util.MessageUtils;
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

    @Autowired
    private ServerProperties serverProperties;

    @Override
    public void sendMessage(String userId, ReqChatMessage req) {
        Message message = createMessage(req);
        messagePublisher.publish(serverProperties.getTopic(), message);

        // 回执
        MessageUtils.send(userId, RespChatMessage.success(req.getId()));
    }

    private Message createMessage(ReqChatMessage req) {
        Message message = new Message();
        message.setId(req.getId());
        message.setContent(req.getContent());
        message.setClientTimestamp(req.getClientTimestamp());
        message.setSender(req.getSender());
        message.setReceiver(req.getReceiver());
        message.setServerTimestamp(System.currentTimeMillis());
        return message;
    }

    @Override
    public void pullMessage(String userId) {

    }
}
