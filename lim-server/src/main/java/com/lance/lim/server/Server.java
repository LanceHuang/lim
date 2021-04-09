package com.lance.lim.server;

import com.lance.lim.server.config.ServerProperties;
import com.lance.lim.server.handler.MessageDecoder;
import com.lance.lim.server.handler.MessageEncoder;
import com.lance.lim.server.handler.ServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * 消息服netty连接
 *
 * @author Lance
 * @since 2021/4/9
 */
@Slf4j
public class Server {

    private ServerProperties serverProperties;

    public Server(ServerProperties serverProperties) {
        this.serverProperties = serverProperties;
    }

    private EventLoopGroup boss;

    private EventLoopGroup worker;

    /**
     * 启动服务器
     */
    public void start() {
        boss = new NioEventLoopGroup(1);
        worker = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap()
                .group(boss, worker)
                .channel(ServerSocketChannel.class)
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
            b.bind(serverProperties.getPort()).sync();
        } catch (InterruptedException e) {
            log.error("Start server failed.", e);
        }
    }

    /**
     * 关闭服务器
     */
    public void shutdown() {
        try {
            if (boss != null) {
                boss.shutdownGracefully().sync();
            }
            if (worker != null) {
                worker.shutdownGracefully().sync();
            }
        } catch (InterruptedException e) {
            log.error("Shutdown server failed.", e);
        }
    }
}
