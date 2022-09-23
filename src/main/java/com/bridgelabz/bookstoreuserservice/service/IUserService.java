package com.bridgelabz.bookstoreuserservice.service;

import com.bridgelabz.bookstoreuserservice.dto.UserDto;
import com.bridgelabz.bookstoreuserservice.model.UserModel;
import com.bridgelabz.bookstoreuserservice.util.UserResponse;
import com.bridgelabz.bookstoreuserservice.util.ResponseToken;

import java.util.List;

public interface IUserService {
    UserResponse createUser(UserDto userDto);

    UserResponse updateUser(Long userId, String token, UserDto userDto);

    List<UserModel> getUserData(String token);

    UserResponse deleteUser(Long userId, String token);

    ResponseToken login(String email, String password);

    UserResponse verify(String token);

    UserResponse resetPassword(String resetPassword, String token);

    UserResponse forgotPassword(String emailId);

    Boolean validate(String token);

    UserResponse sendOtp(String token);

    UserResponse validateOtp(Long otp, String token);

    UserResponse purchaseSubscription(String token);
}
