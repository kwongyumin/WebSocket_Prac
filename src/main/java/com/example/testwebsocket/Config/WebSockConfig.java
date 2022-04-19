package com.example.testwebsocket.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;


@RequiredArgsConstructor
@EnableWebSocketMessageBroker
@Configuration
public class WebSockConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/sub");
        config.setApplicationDestinationPrefixes("/pub");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-stomp").setAllowedOriginPatterns("*")
                .withSockJS();
    }

}
/*
    WebSockChatHandler 를 이용하여 WebSocket을 활성화 하기 위한 Config 파일을 작성
    @EnableWebSocket을 선언 -> WebSocket 활성화 ,
    WebSocket에 접속하기 위한 EndPoint 는 /ws/chat으로 설정하고
    도메인이 다른 서버에서도 접속 가능하도록 CORS : setAllowedOrigins("*")
    를 설정을 추가해 줍니다. 이제 클라이언트가 ws://localhost:8080//ws/chat으로
    커넥션을 연결하고 메시지를 통신할 수 있는 기본적인 준비가 끝!


    --Stomp 활용 고도화 작업
    Stomp를 사용하기 위해서 @EnableWebSocketMessageBroker를 선언 하고
    WebSocketMessageBrokerConfigurer 상속받아와 configureMessageBroker 구현
    pub/sub 메시징을 구현하기 위해 메시지를 발행하는 요청의 prefix 는 /pub 로 시작하도록 설정하고
    메시지를 구독하는 요청의 prefix는 /sub 로 시작하도록 설정합니다.
    그리고 stomp websocket의 연결 endPoint 는 /ws-stomp로 설정합니다.
    따라서 개발서버저의 접속 주소는 다음과 같이 된다.
    ws://localhost:8080/ws-stomp


 */
