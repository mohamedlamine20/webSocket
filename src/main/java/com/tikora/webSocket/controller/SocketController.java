package com.tikora.webSocket.controller;

import com.tikora.webSocket.dto.Message;
import com.tikora.webSocket.service.SocketService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class SocketController {

    private final SocketService socketService;

    public SocketController(SocketService socketService) {
        this.socketService = socketService;
    }

    @PostMapping("/global")
    public void getGlobalMessages(@RequestBody Message message){
        socketService.sendGlobalMessage(message.getMessageContent());
    }
    @PostMapping("/private/{userId}")
    public void getPrivateMessages(@RequestBody Message message,@PathVariable("userId") String userId){
        socketService.sendPrivateMessage(message.getMessageContent(),userId);
    }
}
