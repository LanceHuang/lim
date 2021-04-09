package com.lance.lim.server.util;

import com.lance.lim.server.model.Session;

/**
 * 会话操作工具
 *
 * @author Lance
 * @since 2021/4/9
 */
public class SessionUtils {

    private static final String ATTRIBUTE_USER_ID = "ATTRIBUTE_USER_ID";

    /**
     * 获取用户id
     *
     * @param session 会话
     * @return 用户id
     */
    public static String getUserId(Session session) {
        Object userId = session.getAttribute(ATTRIBUTE_USER_ID);
        return userId == null ? null : userId.toString();
    }
}
