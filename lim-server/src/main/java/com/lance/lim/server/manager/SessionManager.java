package com.lance.lim.server.manager;

import com.lance.lim.server.model.Session;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 会话管理
 *
 * @author Lance
 * @since 2021/4/9
 */
@Component
public class SessionManager {

    private final Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    /**
     * 添加会话
     *
     * @param userId  用户id
     * @param session 会话
     * @return true 添加成功
     */
    public boolean addSession(String userId, Session session) {
        if (userId == null || session == null) {
            return false;
        }

        Session oldSession = sessionMap.putIfAbsent(userId, session);
        if (oldSession != null && !oldSession.equals(session)) {
            // todo
            oldSession.close();
        }
        return true;
    }

    /**
     * 查询会话
     *
     * @param userId 用户id
     * @return 会话
     */
    public Session getSession(String userId) {
        if (userId == null) {
            return null;
        }
        return sessionMap.get(userId);
    }

    /**
     * 查询所有会话
     *
     * @return 所有会话
     */
    public Map<String, Session> getAllSession() {
        return Collections.unmodifiableMap(sessionMap);
    }

    /**
     * 删除会话
     *
     * @param userId 用户id
     * @return true 删除成功
     */
    public boolean removeSession(String userId) {
        if (userId == null) {
            return false;
        }

        sessionMap.remove(userId);
        return true;
    }
}
