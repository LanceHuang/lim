package com.lance.lim.client;

import com.lance.lim.client.config.ClientProperties;
import com.lance.lim.common.util.AbstractLifecycle;
import com.lance.lim.net.handler.MessageDecoder;
import com.lance.lim.net.handler.MessageEncoder;
import com.lance.lim.net.handler.ServerHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * 客户端
 *
 * @author Lance
 * @since 2021/4/11
 */
@Slf4j
public class Client extends AbstractLifecycle {

    private ClientProperties clientProperties;

    private EventLoopGroup worker;

    public Client(ClientProperties clientProperties) {
        this.clientProperties = clientProperties;
    }

    @Override
    public void doStart() {
        worker = new NioEventLoopGroup(1);
        Bootstrap b = new Bootstrap()
                .group(worker)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline().addLast(new LoggingHandler());

                        ch.pipeline().addLast(new MessageEncoder());
                        ch.pipeline().addLast(new MessageDecoder());

                        ch.pipeline().addLast(new ServerHandler());
                    }
                });

        try {
            log.info("客户端开始启动");
            b.connect(clientProperties.getHost(), clientProperties.getPort()).sync();
            log.info("客户端启动成功");
        } catch (InterruptedException e) {
            log.error("Start client failed.", e);
        }
    }

    @Override
    public void doStop() {
        try {
            log.info("客户端开始关闭");
            if (worker != null) {
                worker.shutdownGracefully().sync();
            }
            log.info("客户端关闭成功");
        } catch (InterruptedException e) {
            log.error("Shutdown client failed.", e);
        }
    }
}
