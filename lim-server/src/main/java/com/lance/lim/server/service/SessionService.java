package com.lance.lim.server.service;

import com.lance.lim.server.manager.SessionManager;
import com.lance.lim.server.model.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Lance
 * @since 2021/4/9
 */
@Component
@Slf4j
public class SessionService implements ISessionService {

    @Autowired
    private SessionManager sessionManager;

    @Override
    public void online(String userId, Session session) {
        if (sessionManager.addSession(userId, session)) {
//            log.info("User [{}] online", userId);
            // todo
        } else {

        }
    }

    @Override
    public void offline(String userId) {
        Session session = sessionManager.getSession(userId);
        if (session == null) {
            return;
        }
        sessionManager.removeSession(userId);
        // todo 响应
        session.close();
    }

    @Override
    public void kick(String userId) {
        Session session = sessionManager.getSession(userId);
        if (session == null) {
            return;
        }
        sessionManager.removeSession(userId);
        // todo 响应
        session.close();
    }

    @Override
    public void kickAll() {
        Map<String, Session> allSession = sessionManager.getAllSession();
        List<String> onlineUserIds = new ArrayList<>(allSession.keySet());
        onlineUserIds.forEach(this::kick);
    }

    @Override
    public boolean isOnline(String userId) {
        return sessionManager.getSession(userId) != null;
    }

    @Override
    public Collection<String> getAllOnlineUserId() {
        return sessionManager.getAllSession().keySet();
    }
}
