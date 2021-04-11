package com.lance.lim.net.util;

import io.netty.buffer.ByteBuf;

/**
 * @author Lance
 * @since 2021/4/12
 */
public class ByteBufUtils {

    // todo 数据压缩

    public static void writeInt(ByteBuf buf, int data) {
        buf.writeInt(data);
    }

    public static int readInt(ByteBuf buf) {
        return buf.readInt();
    }
}
