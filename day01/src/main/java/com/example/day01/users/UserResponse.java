package com.example.day01.users;

import java.util.Objects;

public class UserResponse {
	private Integer user_id;
	private String first_name;
	private String last_name;
	private Integer age;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserResponse response = (UserResponse) o;
		return Objects.equals(user_id, response.user_id) && Objects.equals(first_name, response.first_name) && Objects.equals(last_name, response.last_name) && Objects.equals(age, response.age);
	}

	@Override
	public int hashCode() {
		return Objects.hash(user_id, first_name, last_name, age);
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
