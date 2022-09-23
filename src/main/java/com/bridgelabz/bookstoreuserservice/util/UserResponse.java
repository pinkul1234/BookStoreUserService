package com.bridgelabz.bookstoreuserservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class UserResponse {
    private String message;
    private long errorCode;
    private Object object;


    public UserResponse(int errorCode, String message) {
        super();
        this.errorCode = errorCode;
        this.message = message;
    }

    public UserResponse() {
        
    }
}