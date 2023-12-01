package SpringChatGeeks.SpringbootChatGeeks.Repo;

import SpringChatGeeks.SpringbootChatGeeks.Entity.Contact;
import SpringChatGeeks.SpringbootChatGeeks.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableJpaRepositories
@Repository
@CrossOrigin("http://localhost:4200")
public interface ContactRepo extends JpaRepository<Contact,Integer> {
    boolean existsByUserAndContactUser(User user, User contactUser);
}
