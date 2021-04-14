package com.lance.lim.server.service;

import com.lance.lim.core.message.ReqChatMessage;

/**
 * 消息服务
 *
 * @author Lance
 * @since 2021/4/6
 */
public interface IServerService {

    /**
     * 发送聊天消息
     *
     * @param userId 用户id
     * @param req    聊天请求
     */
    void sendMessage(String userId, ReqChatMessage req);

    /**
     * 拉取消息
     *
     * @param userId 用户id
     */
    void pullMessage(String userId);
}
