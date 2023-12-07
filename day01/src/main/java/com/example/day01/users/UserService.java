package com.example.day01.users;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponse getById(int userId) {
        Optional<MyUser> user =  userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User id=%d not found".formatted(userId));
        }

        UserResponse response = new UserResponse();
        response.setUser_id(userId);
        response.setFirst_name(user.get().getFirstName());
        response.setLast_name(user.get().getLastName());
        response.setAge(user.get().getAge());
        return response;
    }

}
