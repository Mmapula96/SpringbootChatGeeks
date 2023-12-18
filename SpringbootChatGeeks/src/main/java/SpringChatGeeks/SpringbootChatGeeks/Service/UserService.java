package SpringChatGeeks.SpringbootChatGeeks.Service;

import SpringChatGeeks.SpringbootChatGeeks.Dto.LoginDto;
import SpringChatGeeks.SpringbootChatGeeks.Dto.UserDto;
import SpringChatGeeks.SpringbootChatGeeks.Entity.User;
import SpringChatGeeks.SpringbootChatGeeks.response.LoginResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    String addUser(UserDto userDTO);

    LoginResponse loginResponse(LoginDto loginDTO);

    LoginResponse loginUser(LoginDto loginDTO);


    List<User> searchUsersByUsername(String username);
    void addContactToChatList(int loggedInUserId, int contactUserId);

    List<User> getChatList(int loggedInUserId);

    User getUserById(int selectedUserId);
}
