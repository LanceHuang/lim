package com.lance.lim.server.service;

import com.lance.lim.server.model.Session;

/**
 * 用户服务
 *
 * @author Lance
 * @since 2021/4/6
 */
public interface IUserService {

    /**
     * 用户上线
     *
     * @param userId  用户id
     * @param session 会话
     */
    void online(String userId, Session session);

    /**
     * 用户离线
     *
     * @param userId 用户id
     */
    void offline(String userId);

    /**
     * 获取连接信息
     *
     * @param userId 用户id
     * @return 会话
     */
    Session getSession(String userId);
}
