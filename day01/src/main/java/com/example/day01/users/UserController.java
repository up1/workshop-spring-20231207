package com.example.day01.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserById(@PathVariable int id) {
        if(id == 2) {
            // TODO :: User id =2 not found
            throw new UserNotFoundException("User id=2 not found");
        }
        // Success = 200
        UserResponse response = new UserResponse();
        response.setUser_id(id);
        response.setFirst_name("somkiat");
        response.setLast_name("pui");
        response.setAge(40);
        return response;
    }

}
