package com.lance.lim.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 消息服上下文
 *
 * @author Lance
 * @since 2021/4/11
 */
@Component
public class ServerContext {

    @Autowired
    private ApplicationContext applicationContext;

    private static ServerContext instance;

    @PostConstruct
    public void init() {
        instance = this;
    }

    public ApplicationContext getApplicationContext() {
        return instance.applicationContext;
    }

    public <T> T getBean(Class<T> requiredType) {
        return instance.applicationContext.getBean(requiredType);
    }
}
