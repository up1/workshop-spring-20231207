package com.example.day01.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public UserErrorResponse handleUserNotFound(UserNotFoundException e) {
        UserErrorResponse response = new UserErrorResponse();
        response.setMessage(e.getMessage());
        return response;
    }

}
