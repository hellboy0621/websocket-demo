package com.xtransformers.websocket.server;

import com.alibaba.fastjson.JSONObject;
import com.xtransformers.websocket.util.WebSocketMapUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author daniel
 * @date 2021-09-01
 */
@Slf4j
@Component
@ServerEndpoint(value = "/websocket")
public class CustomWebSocketServer {

    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        log.info("onOpen " + session.getId());
        WebSocketMapUtil.put(session.getId(), this);
    }

    @OnClose
    public void onClose() {
        WebSocketMapUtil.remove(session.getId());
        log.info("onClose:" + session.getId());
    }

    @OnMessage
    public void onMessage(String params, Session session) throws IOException {
        CustomWebSocketServer customWebSocketServer = WebSocketMapUtil.get(session.getId());
        String msg = "receive message from " + session.getId() + ", message: " + params;
        log.info(msg);
        customWebSocketServer.sendMessage(1, "success", msg);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error(session.getId() + " error", error);
    }

    public void sendMessage(int status, String message, Object data) throws IOException {
        JSONObject result = new JSONObject();
        result.put("status", status);
        result.put("msg", message);
        result.put("data", data);
        session.getBasicRemote().sendText(result.toJSONString());
    }

}
