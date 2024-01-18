package SpringChatGeeks.SpringbootChatGeeks.Controller;

import SpringChatGeeks.SpringbootChatGeeks.Dto.LoginDto;
import SpringChatGeeks.SpringbootChatGeeks.Dto.UserDto;

import SpringChatGeeks.SpringbootChatGeeks.Entity.User;
import SpringChatGeeks.SpringbootChatGeeks.Repo.ContactRepo;
import SpringChatGeeks.SpringbootChatGeeks.Repo.UserRepo;
import SpringChatGeeks.SpringbootChatGeeks.Service.UserService;
import SpringChatGeeks.SpringbootChatGeeks.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private UserRepo userRepo;


    private ContactRepo contactRepo;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody UserDto userDto){
        String id=userService.addUser(userDto);
        return id;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto){

        LoginResponse loginResponse= userService.loginUser(loginDto);
        return ResponseEntity.ok(loginResponse);
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/search/{name}")
    public List<User> searchUsersByUsername(@PathVariable String name) {
        System.out.println("searching");
        List<User> users = userService.searchUsersByUsername(name);
        System.out.println(users);

        return users;
    }
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/{loggedInUserId}/add-contact/{contactUserId}")
    public void addContactToChatList(@PathVariable String loggedInUserId, @PathVariable String contactUserId) {

        userService.addContactToChatList(Integer.parseInt(loggedInUserId), Integer.parseInt(contactUserId));


    }


    @GetMapping("/{loggedInUserId}/chat-list")
    public ResponseEntity<List<User>> getChatList(@PathVariable int loggedInUserId) {
        List<User> chatList = userService.getChatList(loggedInUserId);

        if (chatList != null && !chatList.isEmpty()) {
            return new ResponseEntity<>(chatList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
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
