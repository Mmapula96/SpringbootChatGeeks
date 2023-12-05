package SpringChatGeeks.SpringbootChatGeeks.Repo;

import SpringChatGeeks.SpringbootChatGeeks.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
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


    Optional<User> findByUsername(String username);

    Optional<User> findById(Integer user1Id);

    @Query("SELECT c.contactUser FROM Contact c WHERE c.user.userid = :loggedInUserId")
    List<User> getChatList(@Param("loggedInUserId") int loggedInUserId);

    Optional<User> findById(int id);
}

