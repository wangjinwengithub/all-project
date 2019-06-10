package com.daka.web.config;

import com.daka.web.websocket.DaKaWebSocketService;
import com.daka.web.websocket.WebSocketServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * webSocket配置类
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(webSocketServer(), "/webSocketServer/*");
        webSocketHandlerRegistry.addHandler(daKaWebSocketService(),"/daka/*");
    }

    @Bean
    public WebSocketHandler webSocketServer() {
        return new WebSocketServer();
    }

    @Bean
    public WebSocketHandler daKaWebSocketService(){
        return new DaKaWebSocketService();
    }
}
