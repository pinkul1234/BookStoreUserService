package com.bridgelabz.bookstoreuserservice.exception;

import com.bridgelabz.bookstoreuserservice.util.UserResponse;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus
public class UserNotFoundException extends RuntimeException{
    private int statusCode;
    private String message;

    public UserNotFoundException(int statusCode, String message) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }
}

