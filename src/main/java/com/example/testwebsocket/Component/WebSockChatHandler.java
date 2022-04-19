//package com.example.testwebsocket.Component;
//
//import com.example.testwebsocket.Dto.ChatMessage;
//import com.example.testwebsocket.Dto.ChatRoom;
//import com.example.testwebsocket.Service.ChatService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class WebSockChatHandler extends TextWebSocketHandler {
//
//    private final ObjectMapper objectMapper;
//    private final ChatService chatService;
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
//        String payload = message.getPayload();
//        log.info("payload {}",payload);
////        TextMessage textMessage = new TextMessage("Welcome chatting server~&^");
////        session.sendMessage(textMessage);
//        ChatMessage chatMessage = objectMapper.readValue(payload,ChatMessage.class);
//        ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());
//        room.handleActions(session,chatMessage,chatService);
//
//    }

    //웹 소켓 핸들러
    /*
    소켓 통신은 서버와 클라이언트가 1:N 관계를 맺습니다. 따라서 한 서버에 여러 클라이언트가 접속할 수 있으며,
    서버에는 여러 클라이언트가 발송한 메시지를 받아 처리해줄 Handler 의 작성이 필요하다.
    TextWebSocketHandler 를 상속받아 Handler 를 작성해준다.
    Client로 부터 받은 메시지 를 Console Log 에 출력하고 Client 로 환영 메시지를 보내는 역할을 한다.

    //채팅기능 고도화를 위해 기존 소켓 핸들러 수정

    웹 소켓 클라이언트로부터 채팅 메시지 전달받아 메시지 객체로 변환
    전달받은 메시지에 담긴 채팅방 id 로 발송 대상 채팅방 정보 조회
    해당 채팅방에 입장해있는 모든 클라이언트들에게 타입에 따른 메시지 발송



     */

//}
