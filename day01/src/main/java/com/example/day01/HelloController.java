package com.example.day01;

import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@RestController
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    @Observed(name = "hello-controller", contextualName = "say-hi")
    public HelloResponse sayHi() {

        log.info("Called function sayHi");
        log.info("Called function sayHi");
        log.info("Order saved {}", keyValue("orderId", "0001"));

        HelloResponse response = new HelloResponse();
        response.setMessage("Hello Spring Boot");
        return response;
    }

}
