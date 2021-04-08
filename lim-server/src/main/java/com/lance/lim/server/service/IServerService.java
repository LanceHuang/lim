package com.lance.lim.server.service;

import com.lance.lim.server.model.ChatMessage;

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
     * @param userId  用户id
     * @param chatMsg 聊天消息
     */
    void sendMessage(String userId, ChatMessage chatMsg);
}
