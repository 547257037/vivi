package com.tiantian.api.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

import static com.tiantian.utils.WebSocketUtils.LIVING_SESSIONS_CACHE;
import static com.tiantian.utils.WebSocketUtils.sendMessage;
import static com.tiantian.utils.WebSocketUtils.sendMessageAll;
@RestController
@ServerEndpoint("/ChatController/{username}")
public class ChatController {
    private static final Logger log = LoggerFactory.getLogger(ChatController.class);

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        LIVING_SESSIONS_CACHE.put(username, session);
        String message =  username + " 来到聊天室！";
        log.info(message);
        sendMessageAll(message);

    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {
        log.info(message);
        sendMessageAll(username +":"  + message);
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        //当前的Session 移除
        LIVING_SESSIONS_CACHE.remove(username);
        //并且通知其他人当前用户已经离开聊天室了
        sendMessageAll(  username + " 已经离开聊天室了！");
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throwable.printStackTrace();
    }


    @GetMapping("ChatController/{sender}/to/{receive}")
    public void onMessage(@PathVariable("sender") String sender, @PathVariable("receive") String receive, String message) {
        sendMessage(LIVING_SESSIONS_CACHE.get(receive), sender+":" + message);
    }

}