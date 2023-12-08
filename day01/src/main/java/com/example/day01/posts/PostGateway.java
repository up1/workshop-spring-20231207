package com.example.day01.posts;

import com.example.day01.Gateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Gateway
public class PostGateway {

    @Autowired
    private RestTemplate restTemplate;

    public PostResponse getById(int id) {
        return null;
    }

}
