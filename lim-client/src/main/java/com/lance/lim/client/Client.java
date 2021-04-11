package com.lance.lim.client;

import com.lance.lim.client.config.ClientProperties;
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
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * 客户端
 *
 * @author Lance
 * @since 2021/4/11
 */
@Component
@Slf4j
public class Client implements SmartLifecycle {

    private ClientProperties clientProperties;

    private EventLoopGroup worker;

    private volatile boolean running;

    public Client(ClientProperties clientProperties) {
        this.clientProperties = clientProperties;
    }

    @Override
    public void start() {
        if (this.running) {
            log.error("请勿重复启动客户端");
            return;
        }

        worker = new NioEventLoopGroup();
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
            b.connect().sync();
            log.info("客户端启动成功");
        } catch (InterruptedException e) {
            log.error("Start client failed.", e);
        }

        this.running = true;
    }

    @Override
    public void stop() {
        if (!this.running) {
            log.error("请勿重复关闭客户端");
            return;
        }

        try {
            log.info("客户端开始关闭");
            if (worker != null) {
                worker.shutdownGracefully().sync();
            }
            log.info("客户端关闭成功");
        } catch (InterruptedException e) {
            log.error("Shutdown client failed.", e);
        }
        this.running = false;
    }

    @Override
    public boolean isRunning() {
        return this.running;
    }
}
