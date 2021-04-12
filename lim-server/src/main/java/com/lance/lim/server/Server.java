package com.lance.lim.server;

import com.lance.lim.common.util.AbstractLifecycle;
import com.lance.lim.net.handler.MessageDecoder;
import com.lance.lim.net.handler.MessageEncoder;
import com.lance.lim.net.handler.ServerHandler;
import com.lance.lim.server.config.ServerProperties;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * 消息服netty连接
 *
 * @author Lance
 * @since 2021/4/9
 */
@Slf4j
public class Server extends AbstractLifecycle {

    private ServerProperties serverProperties;

    private EventLoopGroup boss;

    private EventLoopGroup worker;

    public Server(ServerProperties serverProperties) {
        this.serverProperties = serverProperties;
    }

    @Override
    public void doStart() {
        boss = new NioEventLoopGroup(1);
        worker = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap()
                .group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        // todo ssl
                        ch.pipeline().addLast(new LoggingHandler());
                        // todo 心跳校验
//                        ch.pipeline().addLast(new IdleStateHandler(s, 0, 0));
                        ch.pipeline().addLast(new MessageEncoder());
                        ch.pipeline().addLast(new MessageDecoder());
                        // todo ?
                        ch.pipeline().addLast(new ServerHandler());
                    }
                });

        try {
            log.info("服务器开始启动");
            b.bind(serverProperties.getPort()).sync();
            log.info("服务器启动成功");
        } catch (InterruptedException e) {
            log.error("Start server failed.", e);
        }
    }

    @Override
    public void doStop() {
        try {
            log.info("服务器开始关闭");
            if (boss != null) {
                boss.shutdownGracefully().sync();
            }
            if (worker != null) {
                worker.shutdownGracefully().sync();
            }
            log.info("服务器关闭成功");
        } catch (InterruptedException e) {
            log.error("Shutdown server failed.", e);
        }
    }
}
