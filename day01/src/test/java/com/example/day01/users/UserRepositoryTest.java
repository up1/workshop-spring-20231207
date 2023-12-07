package com.example.day01.users;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Success with get user by id = 1")
    public void case01(){
        // Initial data for test
        MyUser user1 = new MyUser();
        user1.setFirstName("somkiat");
        userRepository.save(user1);
        // Test
        Optional<MyUser> user =  userRepository.findById(1);
        assertTrue(user.isPresent());
        assertEquals(1, user.get().getId());
        assertEquals("somkiat", user.get().getFirstName());
    }

}