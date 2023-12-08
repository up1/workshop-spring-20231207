package com.example.day01;

import com.example.day01.customers.Customer;
import com.example.day01.users.MyUser;
import com.example.day01.users.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Day01Application implements CommandLineRunner {

//	@Autowired
//	private UserRepository userRepository;
//
//	@PostConstruct
//	public void initialDataForTest() {
//		MyUser user1 = new MyUser();
//		user1.setFirstName("somkiat");
//		user1.setLastName("pui");
//		user1.setAge(40);
//		userRepository.save(user1);
//	}

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

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {

        jdbcTemplate.execute("DROP TABLE IF EXISTS customers ");
        jdbcTemplate.execute("CREATE TABLE customers(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        // Split up the array of whole names into an array of first/last names
        List<Object[]> splitUpNames = Stream.of("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        splitUpNames.forEach(
                name -> {
                    System.out.printf("Inserting customer record for %s %s%n", name[0], name[1]);
                });

        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

        jdbcTemplate.query(
                        "SELECT id, first_name, last_name FROM customers WHERE first_name = ?",
                        (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")), "Josh")
                .forEach(customer -> System.out.println(customer.toString()));
    }

}
