package com.example.testwebsocket.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@RequiredArgsConstructor
@EnableWebSocket
@Configuration
public class WebSockConfig implements WebSocketConfigurer {
    private final WebSocketHandler webSocketHandler;


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler,"/ws/chat").setAllowedOrigins("*");
    }
}
/*
    WebSockChatHandler 를 이용하여 WebSocket을 활성화 하기 위한 Config 파일을 작성
    @EnableWebSocket을 선언 -> WebSocket 활성화 ,
    WebSocket에 접속하기 위한 EndPoint 는 /ws/chat으로 설정하고
    도메인이 다른 서버에서도 접속 가능하도록 CORS : setAllowedOrigins("*")
    를 설정을 추가해 줍니다. 이제 클라이언트가 ws://localhost:8080//ws/chat으로
    커넥션을 연결하고 메시지를 통신할 수 있는 기본적인 준비가 끝!


 */
