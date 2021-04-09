package com.lance.lim.server.packet;

import com.lance.lim.server.annotation.Message;
import lombok.Getter;
import lombok.Setter;

/**
 * 发送消息
 *
 * @author Lance
 * @since 2021/4/9
 */
@Getter
@Setter
@Message(1024)
public class ReqChatMessage {

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
