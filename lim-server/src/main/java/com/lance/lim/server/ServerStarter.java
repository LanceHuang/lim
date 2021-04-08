package com.lance.lim.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.util.StopWatch;

/**
 * @author Lance
 * @since 2021/4/8
 */
@SpringBootApplication
@Slf4j
public class ServerStarter {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        new SpringApplicationBuilder(ServerStarter.class).run();
        stopWatch.stop();
        log.info("============== 启动耗时：{}ms", stopWatch.getTotalTimeMillis());
    }
}
