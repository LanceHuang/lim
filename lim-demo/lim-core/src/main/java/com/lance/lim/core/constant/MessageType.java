package com.lance.lim.core.constant;

/**
 * 消息类型
 *
 * @author Lance
 * @since 2021/4/12
 */
public enum MessageType {

    /** 公聊 */
    WORLD(1),
    /** 私聊 */
    PRIVATE(2),
    /** 组聊 */
    GROUP(3);

    /** 消息类型 */
    private int type;

    MessageType(int type) {
        this.type = type;
    }

    public static MessageType typeOf(int type) {
        for (MessageType messageType : values()) {
            if (messageType.type == type) {
                return messageType;
            }
        }
        return null;
    }

    public int getType() {
        return type;
    }
}
