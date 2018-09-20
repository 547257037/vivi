package com.tiantian.utils;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketUtils {
    /**
     * 模拟存储 websocket session 使用
     */
    public static final Map<String, Session> LIVING_SESSIONS_CACHE = new ConcurrentHashMap<>();

    public static void sendMessageAll(String message) {
        LIVING_SESSIONS_CACHE.forEach((sessionId, session) -> sendMessage(session, message));
    }

    /**
     * 发送给指定用户消息
     *
     * @param session 用户 session
     * @param message 发送内容
     */
    public static void sendMessage(Session session, String message) {
        if (session == null) {
            return;
        }

        //volatile修饰，只是保证每次取a的值都不是从缓存中取，而是从a所真正对应的内存地址中取
        //就是getAsyncRemote是非阻塞式的，getBasicRemote是阻塞式的
        final RemoteEndpoint.Async async = session.getAsyncRemote();

        if (async == null) {
            return;
        }
        async.sendText(message);
    }
}