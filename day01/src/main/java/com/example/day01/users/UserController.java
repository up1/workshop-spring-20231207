package com.example.day01.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserById(@PathVariable int id) {
        return userService.getById(id);
    }

    // /users?page=1&size=10
    @GetMapping("/users")
    public List<UserResponse> getAll(@RequestParam(defaultValue = "1") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        System.out.println("Page=" + page);
        System.out.println("Size=" + size);
        return null;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createNewUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        userResponse.setFirst_name(userRequest.getFirst_name());
        userResponse.setLast_name(userRequest.getLast_name());
        return userResponse;
    }

}
