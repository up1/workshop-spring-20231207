package com.example.day01.posts;

import com.example.day01.Gateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Gateway
public class PostGateway {

    @Autowired
    private RestTemplate restTemplate;

    public Optional<PostResponse> getById(int id) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        try {
            PostResponse result = restTemplate.getForObject(url, PostResponse.class);
            return Optional.of(result);
        }catch (RestClientException e) {
            return Optional.empty();
        }
    }

}
