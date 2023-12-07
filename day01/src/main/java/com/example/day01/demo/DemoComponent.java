package com.example.day01.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoComponent {

    @Autowired
    private MyService service2;

}
