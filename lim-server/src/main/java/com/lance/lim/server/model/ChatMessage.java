package com.lance.lim.server.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 聊天消息
 *
 * @author Lance
 * @since 2021/4/6
 */
@Getter
@Setter
public class ChatMessage {

    /** 消息id */
    private long id;

    /** 消息内容 */
    private String content;

    /** 客户端时间戳 */
    private long clientTimestamp;

    /** 发送者 */
    private String sender;

    /** 接收者 */
    private String receiver;
}
