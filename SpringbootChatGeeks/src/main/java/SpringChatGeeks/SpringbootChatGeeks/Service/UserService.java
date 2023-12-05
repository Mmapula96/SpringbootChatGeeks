package SpringChatGeeks.SpringbootChatGeeks.Service;

import SpringChatGeeks.SpringbootChatGeeks.Dto.LoginDTO;
import SpringChatGeeks.SpringbootChatGeeks.Dto.UserDTO;
import SpringChatGeeks.SpringbootChatGeeks.Entity.User;
import SpringChatGeeks.SpringbootChatGeeks.response.LoginResponse;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserService {
    String addUser(UserDTO userDTO);

    LoginResponse loginResponse(LoginDTO loginDTO);

    LoginResponse loginUser(LoginDTO loginDTO);


    List<User> searchUsersByUsername(String username);
    void addContactToChatList(int loggedInUserId, int contactUserId);

    List<User> getChatList(int loggedInUserId);

    User getUserById(int selectedUserId);
}
