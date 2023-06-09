package com.tikora.webSocket.controller;

import com.tikora.webSocket.dto.Message;
import com.tikora.webSocket.dto.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;

@Controller
public class MessageController {



        @MessageMapping("/message")
        @SendTo("/topic/messages")
        public ResponseMessage getMessage(final Message message)  {
            return new ResponseMessage(HtmlUtils.htmlEscape(message.getMessageContent()));
        }

        @MessageMapping("/private-message")
        @SendToUser("/topic/private-messages")
        public ResponseMessage getPrivateMessage(final Message message,
                                                 final Principal principal)   {
            return new ResponseMessage(HtmlUtils.htmlEscape(
                    "Sending private message to user " + principal.getName() + ": "
                            + message.getMessageContent())
            );
        }
    }
