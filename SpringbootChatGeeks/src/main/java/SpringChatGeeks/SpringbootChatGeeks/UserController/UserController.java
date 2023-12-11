package SpringChatGeeks.SpringbootChatGeeks.UserController;

import SpringChatGeeks.SpringbootChatGeeks.Dto.LoginDTO;
import SpringChatGeeks.SpringbootChatGeeks.Dto.UserDTO;

import SpringChatGeeks.SpringbootChatGeeks.Entity.User;
import SpringChatGeeks.SpringbootChatGeeks.Repo.ContactRepo;
import SpringChatGeeks.SpringbootChatGeeks.Repo.UserRepo;
import SpringChatGeeks.SpringbootChatGeeks.Service.UserService;
import SpringChatGeeks.SpringbootChatGeeks.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    private UserRepo userRepo;


    private ContactRepo contactRepo;

    //get all the users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    //search the user by thier username
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/search/{name}")
    public List<User> searchUsersByUsername(@PathVariable String name) {
        System.out.println("searching");
        List<User> users =userService.searchUsersByUsername(name);
        System.out.println(users);

        return userService.searchUsersByUsername(name);
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Register the user
    @PostMapping("/save")
    public String saveUser(@RequestBody UserDTO userDTO){
        String id=userService.addUser(userDTO);
        return id;
    }
    //The user login

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){

        LoginResponse loginResponse= userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    //add the user I searched to the chat list

    @PostMapping("/{loggedInUserId}/add-contact/{contactUserId}")
    public void addContactToChatList(@PathVariable String loggedInUserId, @PathVariable String contactUserId) {

        userService.addContactToChatList(Integer.parseInt(loggedInUserId), Integer.parseInt(contactUserId));


    }

    //get the user I added to the chatlist
    @GetMapping("/{loggedInUserId}/chat-list")
    public ResponseEntity<List<User>> getChatList(@PathVariable int loggedInUserId) {
        List<User> chatList = userService.getChatList(loggedInUserId);
        return ResponseEntity.ok(chatList);

    }

    //select the user to be able to start the conversation
    @GetMapping("/selected-user/{selectedUserId}")
    public ResponseEntity<User> getSelectedUser(@PathVariable int selectedUserId) {
        // Retrieve detailed information about the selected user
        User selectedUser = userService.getUserById(selectedUserId);

        if (selectedUser == null) {
            return ResponseEntity.notFound().build();
        }

        // You can add more details or modify the user object as needed
        return ResponseEntity.ok(selectedUser);
    }


}
