package com.example.day01;

import com.example.day01.users.UserResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Day01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context
				= SpringApplication.run(Day01Application.class, args);

//		UserResponse ur1 = (UserResponse)context.getBean("userResponse");
//		ur1.setUser_id(1);
//
//		UserResponse ur2 = (UserResponse)context.getBean("userResponse");
//		ur2.setUser_id(2);
//
//		System.out.println(ur1.getUser_id());
//		System.out.println(ur2.getUser_id());
	}

}
