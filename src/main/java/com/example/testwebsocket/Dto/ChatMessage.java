package com.example.testwebsocket.Dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChatMessage {
    //메시지 타입 : 입장/ 채팅
    // 채팅방입장과 대화하기를 enum으로 선언
    public enum MessageType{
        ENTER,TALK
    }
    //메시지 타입
    private MessageType type;
    //방번호
    private String roomId;
    //메시지 보낸사람
    private String sender;
    //메시지
   private String message;

}
