package com.lance.lim.server.controller;

import com.lance.lim.server.annotation.MessageHandler;
import com.lance.lim.server.model.Session;
import com.lance.lim.server.packet.ReqChatMessage;
import com.lance.lim.server.service.IServerService;
import com.lance.lim.server.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Lance
 * @since 2021/4/9
 */
@Component
public class ServerController {

    @Autowired
    private IServerService serverService;

    @MessageHandler
    public void onChatMessage(Session session, ReqChatMessage req) {
        String userId = SessionUtils.getUserId(session);
        serverService.sendMessage(userId, req);
    }
}
