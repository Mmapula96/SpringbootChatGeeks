package SpringChatGeeks.SpringbootChatGeeks.Controller;


import SpringChatGeeks.SpringbootChatGeeks.Entity.ChatMessage;
import SpringChatGeeks.SpringbootChatGeeks.Repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;




@Controller
public class MessageController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private MessageRepo messageRepo;

//    @MessageMapping("/sendMessage")
//    @SendTo("/topic/messages")
//    public void sendMessage(ChatMessage chatMessage) {
//
//        messageRepo.save(chatMessage);
//        // Send the message to the specified conversation
////         messagingTemplate.convertAndSend("/topic/messages/" , chatMessage);
//
//        // Ensure that the conversationId is set correctly in the ChatMessage
//        String conversationTopic = "/topic/messages/" + chatMessage.getConversationId();
//
//        // Send the message to the specified conversation
//        messagingTemplate.convertAndSend(conversationTopic, chatMessage);
//        System.out.println("sent to topic");
//
//
//    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        // Assuming you have a repository to save the message
        messageRepo.save(chatMessage);

        // Ensure that the conversationId is set correctly in the ChatMessage
        String conversationTopic = "/topic/messages/" + chatMessage.getConversationId();

        // Send the message to the specified conversation
        messagingTemplate.convertAndSend(conversationTopic, chatMessage);

        System.out.println("Sent message to topic: " + conversationTopic);

        // Return the saved chat message
        return chatMessage;
    }
}


