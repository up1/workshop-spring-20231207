package com.example.day01;

import com.example.day01.users.MyUser;
import com.example.day01.users.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Day01Application {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initialDataForTest() {
		MyUser user1 = new MyUser();
		user1.setFirstName("somkiat");
		user1.setLastName("pui");
		user1.setAge(40);
		userRepository.save(user1);
	}

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
