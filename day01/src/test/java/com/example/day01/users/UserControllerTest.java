package com.example.day01.users;

import com.example.day01.HelloResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("success case for get user by id =1")
    void getUserById() {
        UserResponse result
                = restTemplate.getForObject("/users/1", UserResponse.class);
        assertEquals(1, result.getUser_id());
        assertEquals("somkiat", result.getFirst_name());
        assertEquals("pui", result.getLast_name());
        assertEquals(40, result.getAge());

        // Compare object
        UserResponse expected = new UserResponse();
        expected.setUser_id(1);
        expected.setFirst_name("somkiat");
        expected.setLast_name("pui");
        expected.setAge(40);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("user not found case for get user by id =2")
    void getUserById2() {
        ResponseEntity<UserErrorResponse> result
                = restTemplate.getForEntity("/users/2", UserErrorResponse.class);
        assertEquals(200, result.getStatusCode().value());
        assertEquals("User id=2 not found", result.getBody().getMessage());

    }
}