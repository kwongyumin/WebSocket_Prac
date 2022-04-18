package com.example.testwebsocket.Controller;


import com.example.testwebsocket.Dto.ChatRoom;
import com.example.testwebsocket.Service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {



    private final ChatService chatService;

    @PostMapping //채팅방 생성
    public ChatRoom createRoom(@RequestParam String name){
        return chatService.createRoom(name);
    }

    @GetMapping  //채팅방 조회
    public List<ChatRoom> findAllRoom(){
        return chatService.findAllRoom();
    }

}
