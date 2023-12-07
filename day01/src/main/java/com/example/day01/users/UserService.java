package com.example.day01.users;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserResponse getById(int userId) {
        if(userId == 2) {
            throw new UserNotFoundException("User id=2 not found");
        }
        UserResponse response = new UserResponse();
        response.setUser_id(userId);
        response.setFirst_name("somkiat");
        response.setLast_name("pui");
        response.setAge(40);
        return response;
    }

}
