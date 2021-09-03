package com.xtransformers.websocket.util;

import com.xtransformers.websocket.server.CustomWebSocketServer;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author daniel
 * @date 2021-09-01
 */
public class WebSocketMapUtil {

    public static ConcurrentHashMap<String, CustomWebSocketServer> webSocketMap = new ConcurrentHashMap<>();

    public static void put(String key, CustomWebSocketServer customWebSocketServer) {
        webSocketMap.put(key, customWebSocketServer);
    }

    public static CustomWebSocketServer get(String key) {
        return webSocketMap.get(key);
    }

    public static void remove(String key) {
        webSocketMap.remove(key);
    }

    public static Collection<CustomWebSocketServer> getValues() {
        return webSocketMap.values();
    }
}
