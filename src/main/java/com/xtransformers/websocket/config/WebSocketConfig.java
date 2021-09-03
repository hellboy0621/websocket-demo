package com.xtransformers.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author daniel
 * @date 2021-09-01
 */
@Configuration
public class WebSocketConfig {

    /**
     * 该Bean 会自动注册使用 @ServerEndpoint 注解申明的 WebSocket endpoint
     *
     * @return ServerEndpointExporter
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
