package com.lance.lim.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.util.StopWatch;

/**
 * 客户端启动器
 *
 * @author Lance
 * @since 2021/4/8
 */
@SpringBootApplication
@Slf4j
public class ClientStarter {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        new SpringApplicationBuilder(ClientStarter.class).run();
        stopWatch.stop();
        log.info("============== 客户端启动耗时：{}ms ==============", stopWatch.getTotalTimeMillis());
    }
}
