package com.lance.lim.server.service;

import com.lance.lim.server.model.Session;

import java.util.Collection;

/**
 * 会话服务
 *
 * @author Lance
 * @since 2021/4/9
 */
public interface ISessionService {

    /**
     * 用户上线
     *
     * @param userId  用户id
     * @param session 会话
     */
    void online(String userId, Session session);

    /**
     * 用户下线
     *
     * @param userId 用户id
     */
    void offline(String userId);

    /**
     * 踢用户下线
     *
     * @param userId 用户id
     */
    void kick(String userId);

    /**
     * 踢所有用户下线
     */
    void kickAll();

    /**
     * 判断用户是否在线
     *
     * @param userId 用户id
     * @return true 用户在线
     */
    boolean isOnline(String userId);

    /**
     * 获取所有在线用户id
     *
     * @return 所有在线用户id
     */
    Collection<String> getAllOnlineUserId();
}
