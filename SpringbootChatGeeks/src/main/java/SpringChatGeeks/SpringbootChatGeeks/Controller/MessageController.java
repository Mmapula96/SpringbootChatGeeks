package SpringChatGeeks.SpringbootChatGeeks.Controller;


import SpringChatGeeks.SpringbootChatGeeks.Entity.ChatMessage;
import SpringChatGeeks.SpringbootChatGeeks.Repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/messages")
public class MessageController {


    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private MessageRepo messageRepo;

    @MessageMapping("/topic/messages")
    public void sendMessage(ChatMessage chatMessage) {
        messageRepo.save(chatMessage);
        System.out.println("Received message: " + chatMessage);
        System.out.println("Sending message to /topic/messages/");
        messagingTemplate.convertAndSend("/topic/messages/", chatMessage);

        String conversationTopic = "/app/topic/messages/" + chatMessage.getConversationId();
        System.out.println("Sending message to " + conversationTopic);
        messagingTemplate.convertAndSend(conversationTopic, chatMessage);
    }

    @GetMapping("messages/{conversationId}")
    public List<ChatMessage> getConversationMessages(@PathVariable String conversationId) {
        // Retrieve messages for the specified conversation from the database
        return messageRepo.findByConversationId(conversationId);
    }



}


