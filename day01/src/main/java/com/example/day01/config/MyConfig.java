package com.example.day01.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {

    @Bean
    public RestTemplate xyz(){
        return new RestTemplateBuilder().build();
    }

}

// Builder pattern
class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee();

        Employee e2 = new EmployeeBuilder()
                        .addName("").build();
    }
}

class Employee {
    int id;
    String name;
}

class EmployeeBuilder {
    Employee employee = new Employee();
    public EmployeeBuilder addName(String name) {
        employee.name = name;
        return this;
    }
    public Employee build() {
        return  employee;
    }
}
