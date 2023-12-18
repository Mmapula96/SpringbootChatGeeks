package SpringChatGeeks.SpringbootChatGeeks.Repo;

import SpringChatGeeks.SpringbootChatGeeks.Entity.ChatMessage;
import SpringChatGeeks.SpringbootChatGeeks.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@EnableJpaRepositories
@Repository
@CrossOrigin("http://localhost:4200")
public interface MessageRepo extends JpaRepository<ChatMessage,Integer> {

}
