package SpringChatGeeks.SpringbootChatGeeks.Repo;

import SpringChatGeeks.SpringbootChatGeeks.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
@CrossOrigin("http://localhost:4200")
public interface UserRepo extends JpaRepository<User,Integer> {

    Optional<User> findOneByEmailAndPassword(String email,String password);

    User findByEmail(String email);

    List<User> findByUsernameContaining(String username);



}

