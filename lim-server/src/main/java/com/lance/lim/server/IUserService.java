package com.lance.lim.server;

import com.lance.lim.server.model.ConnectInfo;

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
     * @param userId      用户id
     * @param connectInfo 连接信息
     */
    void online(String userId, ConnectInfo connectInfo);

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
     * @return 连接信息
     */
    ConnectInfo getConnectInfo(String userId);
}
