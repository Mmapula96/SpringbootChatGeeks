package SpringChatGeeks.SpringbootChatGeeks.Repo;

import SpringChatGeeks.SpringbootChatGeeks.Entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;


@EnableJpaRepositories
@Repository
@CrossOrigin("http://localhost:4200")
public interface MessageRepo extends JpaRepository<ChatMessage,Integer> {
    List<ChatMessage> findByConversationId(String conversationId);


    Optional<ChatMessage> findTopByConversationIdOrderByTimestampDesc(String conversationId);
}
