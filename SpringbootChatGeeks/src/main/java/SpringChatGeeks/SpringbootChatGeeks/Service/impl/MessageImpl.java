package SpringChatGeeks.SpringbootChatGeeks.Service.impl;


import SpringChatGeeks.SpringbootChatGeeks.Entity.ChatMessage;
import SpringChatGeeks.SpringbootChatGeeks.Repo.MessageRepo;
import SpringChatGeeks.SpringbootChatGeeks.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageImpl implements MessageService {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    public void MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }


    public void saveMessage(ChatMessage chatMessage) {
        messageRepo.save(chatMessage);
    }

}
