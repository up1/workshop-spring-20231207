package com.example.day01.posts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostGatewayTest {

    @Autowired
    private PostGateway postGateway;

    @Test
    @DisplayName("Success case to call post api with id=1")
    void getById() {
        Optional<PostResponse> result = postGateway.getById(1);
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
        assertEquals(1, result.get().getUserId());
        assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", result.get().getTitle());
    }
}