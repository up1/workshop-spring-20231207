package com.example.day01.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id) {
        UserResponse response = new UserResponse();
        response.setUserId(id);
        response.setFirstName("somkiat");
        response.setLastName("pui");
        response.setAge(40);
        return response;
    }

}
