package com.digitaldark.ChambeaPe_Api.chat.controller;

import com.digitaldark.ChambeaPe_Api.chat.dto.ChatDTO;
import com.digitaldark.ChambeaPe_Api.chat.dto.request.ChatRequestDTO;
import com.digitaldark.ChambeaPe_Api.chat.dto.request.MessageRequestDTO;
import com.digitaldark.ChambeaPe_Api.chat.dto.response.ChatResponseDTO;
import com.digitaldark.ChambeaPe_Api.chat.dto.response.MessageResponseDTO;
import com.digitaldark.ChambeaPe_Api.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:4200") // Puerto de Angular
@CrossOrigin(origins = "*")
public class ChatController {
    @Autowired
    private ChatService chatService;

    //URL: http://localhost:8080/api/v1/chats/users/{userId}
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/chats/users/{userId}")
    public ResponseEntity<List<ChatDTO>> getAllChatsByUserId(@PathVariable("userId") int userId) {
        return new ResponseEntity<List<ChatDTO>>(chatService.getChatsByUserId(userId), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/chats
    //Method: POST
    @Transactional
    @PostMapping("/chats")
    public ResponseEntity<ChatResponseDTO> createChat(@RequestBody ChatRequestDTO chat) {
        return new ResponseEntity<ChatResponseDTO>(chatService.createChat(chat), HttpStatus.CREATED);
    }

    //URL: http://localhost:8080/api/v1/chats/{chatId}/messages
    //Method: POST
    @Transactional
    @PostMapping("/chats/{chatId}/messages")
    public ResponseEntity<MessageResponseDTO> createMessage(@RequestBody MessageRequestDTO message, @PathVariable("chatId") int chatId) {
        return new ResponseEntity<MessageResponseDTO>(chatService.createMessage(message, chatId), HttpStatus.CREATED);
    }
}
