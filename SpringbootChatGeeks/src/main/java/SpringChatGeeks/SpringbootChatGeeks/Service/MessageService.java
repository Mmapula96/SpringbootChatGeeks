package SpringChatGeeks.SpringbootChatGeeks.Service;


import SpringChatGeeks.SpringbootChatGeeks.Entity.ChatMessage;
import org.springframework.stereotype.Service;



public interface MessageService {

    void saveMessage(ChatMessage chatMessage);

}
