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

//Get all the contacts
    private ContactRepo contactRepo;
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

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
//register the user
    @PostMapping("/save")
    public String saveUser(@RequestBody UserDTO userDTO){
        String id=userService.addUser(userDTO);
        return id;
    }
//user login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){

        LoginResponse loginResponse= userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    //Add contacts to the chatlist

    @PostMapping("/{loggedInUserId}/add-contact/{contactUserId}")
    public void addContactToChatList(@PathVariable String loggedInUserId, @PathVariable String contactUserId) {

        userService.addContactToChatList(Integer.parseInt(loggedInUserId), Integer.parseInt(contactUserId));


    }

    //get them to the chatlist
    @GetMapping("/{loggedInUserId}/chat-list")
    public ResponseEntity<List<User>> getChatList(@PathVariable int loggedInUserId) {
        List<User> chatList = userService.getChatList(loggedInUserId);
        return ResponseEntity.ok(chatList);

    }

    //select the user i added from the chatist to appearon the chat thread
    @GetMapping("/selected-user/{selectedUserId}")
    public ResponseEntity<User> getSelectedUser(@PathVariable int selectedUserId) {
        // Retrieve detailed information about the selected user
        User selectedUser = userService.getUserById(selectedUserId);

        if (selectedUser == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(selectedUser);
    }


}
