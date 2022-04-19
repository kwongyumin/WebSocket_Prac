package com.example.testwebsocket.Controller;


import com.example.testwebsocket.Dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {



//    private final ChatService chatService;
//
//    @PostMapping //채팅방 생성
//    public ChatRoom createRoom(@RequestParam String name){
//        return chatService.createRoom(name);
//    }
//
//    @GetMapping  //채팅방 조회
//    public List<ChatRoom> findAllRoom(){
//        return chatService.findAllRoom();
//    }
//-- Stomp 고도화작업
// 기존의 소켓 핸들러가 하던 역할을 대체한다.

    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/message") // 메시지 발행을 처리 ,
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getType()))
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

}
