package com.lance.lim.common.message;

import com.lance.lim.net.annotation.Message;
import lombok.Getter;
import lombok.Setter;

/**
 * 发送消息回执
 *
 * @author Lance
 * @since 2021/4/11
 */
@Getter
@Setter
@Message(1025)
public class RespChatMessage {

    /** 消息id */
    private long id;

    /** 发送状态 */
    private boolean result;

    /** 错误消息 */
    private String message;

    public static RespChatMessage success(long id) {
        RespChatMessage resp = new RespChatMessage();
        resp.id = id;
        resp.result = true;
        return resp;
    }

    public static RespChatMessage fail(long id, String message) {
        RespChatMessage resp = new RespChatMessage();
        resp.id = id;
        resp.result = false;
        resp.message = message;
        return resp;
    }
}
