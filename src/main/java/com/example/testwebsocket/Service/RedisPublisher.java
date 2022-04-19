package com.example.testwebsocket.Service;


import com.example.testwebsocket.Dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;



//레디스 발행 서비스

@RequiredArgsConstructor
@Service
public class RedisPublisher {
    private final RedisTemplate<String, Object> redisTemplate;

    public void publish(ChannelTopic topic, ChatMessage message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
        //채팅방 입장 후 메시지 작성 -> 해당 메시지를 토픽에 발행하는 서비스
        //해당 서비스를 통해 메시지를 발행하면 대기하고 있던 redis 구독 서비스가 메시지를 처리합니다.
}

