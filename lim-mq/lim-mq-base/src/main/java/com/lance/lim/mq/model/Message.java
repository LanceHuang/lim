package com.lance.lim.mq.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 消息
 *
 * @author Lance
 * @since 2021/4/8
 */
@Getter
@Setter
public class Message {

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

    /** 服务端时间戳 */
    private long serverTimestamp;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", clientTimestamp=" + clientTimestamp +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", serverTimestamp=" + serverTimestamp +
                '}';
    }
}
