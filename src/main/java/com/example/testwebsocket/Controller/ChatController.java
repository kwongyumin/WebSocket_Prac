package com.example.testwebsocket.Controller;


import com.example.testwebsocket.Dto.ChatMessage;
import com.example.testwebsocket.Repository.ChatRoomRepository;
import com.example.testwebsocket.Service.RedisPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
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
    // -- redis 고도화 작업

    //private final SimpMessageSendingOperations messagingTemplate;

    private final RedisPublisher redisPublisher;
    private final ChatRoomRepository chatRoomRepository;


    //웹소켓 "/pub/chat/message" 로 들어오는 메시징을 처리
    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
            chatRoomRepository.enterChatRoom(message.getRoomId());
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        }
       //  messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
        redisPublisher.publish(chatRoomRepository.getTopic(message.getRoomId()), message);
    }
}
