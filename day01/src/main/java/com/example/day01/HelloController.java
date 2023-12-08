package com.example.day01;

import io.micrometer.observation.annotation.Observed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    @Observed(name = "hello-controller", contextualName = "say-hi")
    public HelloResponse sayHi() {
        HelloResponse response = new HelloResponse();
        response.setMessage("Hello Spring Boot");
        return response;
    }

}
