package com.tikora.webSocket.service;
import com.tikora.webSocket.dto.ResponseMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SocketService {



    private final SimpMessagingTemplate messageSendingOperations;

    public SocketService(SimpMessagingTemplate messageSendingOperations) {
        this.messageSendingOperations = messageSendingOperations;
    }

    public void sendGlobalMessage(String message) {
    messageSendingOperations.convertAndSend("/topic/messages",new ResponseMessage(message));

    }
    public void sendPrivateMessage(String message,String userId) {
        messageSendingOperations.convertAndSendToUser(userId,"/topic/private-messages",new ResponseMessage(message));

    }
}
