package SpringChatGeeks.SpringbootChatGeeks.Service.impl;

import SpringChatGeeks.SpringbootChatGeeks.Dto.LoginDto;
import SpringChatGeeks.SpringbootChatGeeks.Dto.UserDto;
import SpringChatGeeks.SpringbootChatGeeks.Entity.Contact;
import SpringChatGeeks.SpringbootChatGeeks.Entity.User;
import SpringChatGeeks.SpringbootChatGeeks.Repo.ContactRepo;
import SpringChatGeeks.SpringbootChatGeeks.Repo.UserRepo;
import SpringChatGeeks.SpringbootChatGeeks.Service.UserService;
import SpringChatGeeks.SpringbootChatGeeks.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ContactRepo contactRepo;


    @Override
    public List<User> searchUsersByUsername(String username) {
        return userRepo.findByUsernameContaining(username);

    }


    @Override
    public String addUser(UserDto userDTO) {
        User user = new User(
                userDTO.getUsername(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(UserDto.getPassword())
        );
        System.out.println("adding " + user.toString());
        userRepo.save(user);

        return user.getUsername();


    }


    @Override
    public LoginResponse loginResponse(LoginDto loginDTO) {
        return null;
    }


    @Override
    public LoginResponse loginUser(LoginDto loginDTO) {
        User user1 = userRepo.findByEmail(loginDTO.getEmail());

        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);

            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);

                if (user.isPresent()) {
                    return new LoginResponse("Login Successful", true, user);
                } else {
                    return new LoginResponse("Incorrect Email or Password", false, user);
                }
            } else {
                return new LoginResponse("Incorrect password", false, null);
            }
        } else {
            // User not found
            return new LoginResponse("User not found", false, null);
        }
    }

    @Override
    public void addContactToChatList(int loggedInUserId, int contactUserId) {
        // Implement logic to add a contact to the user's chat list
        User loggedInUser = userRepo.findById(loggedInUserId).orElse(null);
        User contactUser = userRepo.findById(contactUserId).orElse(null);

        if (loggedInUser != null && contactUser != null) {

            if(loggedInUser.equals(contactUser)){
                throw new IllegalArgumentException("Cannot add yourself");
            }



            if (!contactRepo.existsByUserAndContactUser(loggedInUser, contactUser)) {
                Contact contact = new Contact(loggedInUser, contactUser);
                contactRepo.save(contact);
                System.out.println("Contact added successfully!");
            }else {
                // The contact is already in the chat list
                System.out.println("Contact is already in the chat list.");
            }
        }
    }

    @Override
    public List<User> getChatList(int loggedInUserId) {
        return userRepo.getChatList(loggedInUserId);
    }

    public User getUserById(int userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        return userOptional.orElse(null);
    }


}


