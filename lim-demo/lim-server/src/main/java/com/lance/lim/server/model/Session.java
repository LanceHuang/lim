package com.lance.lim.server.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 会话
 *
 * @author Lance
 * @since 2021/4/6
 */
public class Session {

    /** 属性 */
    private final Map<String, Object> attributes = new ConcurrentHashMap<>();

    /**
     * 设置属性
     *
     * @param key   键
     * @param value 值
     */
    public void setAttribute(String key, Object value) {
        if (key == null || value == null) {
            return;
        }
        attributes.put(key, value);
    }

    /**
     * 获取属性
     *
     * @param key 键
     * @return 值
     */
    public Object getAttribute(String key) {
        if (key == null) {
            return null;
        }
        return attributes.get(key);
    }

    /**
     * 获取属性
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 值
     */
    public Object getAttributeOrElse(String key, Object defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        return attributes.getOrDefault(key, defaultValue);
    }

    /**
     * 关闭会话
     */
    public void close() {
        // todo
    }
}
