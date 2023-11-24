package SpringChatGeeks.SpringbootChatGeeks.Service;

import SpringChatGeeks.SpringbootChatGeeks.Dto.LoginDTO;
import SpringChatGeeks.SpringbootChatGeeks.Dto.UserDTO;
import SpringChatGeeks.SpringbootChatGeeks.Entity.User;
import SpringChatGeeks.SpringbootChatGeeks.response.LoginResponse;

import java.util.List;

public interface UserService {
    String addUser(UserDTO userDTO);

    LoginResponse loginResponse(LoginDTO loginDTO);

    LoginResponse loginUser(LoginDTO loginDTO);


    List<User> searchUsersByUsername(String username);
}
