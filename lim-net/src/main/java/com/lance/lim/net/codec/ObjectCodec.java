package com.lance.lim.net.codec;

import io.netty.buffer.ByteBuf;

/**
 * @author Lance
 * @since 2021/4/12
 */
public class ObjectCodec extends Codec {

    @Override
    public void encode(ByteBuf buf, Object object) {

    }

    @Override
    public Object decode(ByteBuf buf) {
        return null;
    }
}
