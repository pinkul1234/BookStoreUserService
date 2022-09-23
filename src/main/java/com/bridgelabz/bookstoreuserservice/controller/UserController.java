package com.bridgelabz.bookstoreuserservice.controller;

import com.bridgelabz.bookstoreuserservice.dto.UserDto;
import com.bridgelabz.bookstoreuserservice.model.UserModel;
import com.bridgelabz.bookstoreuserservice.service.IUserService;
import com.bridgelabz.bookstoreuserservice.util.UserResponse;
import com.bridgelabz.bookstoreuserservice.util.ResponseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping("/createuser")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserDto userDto){
        UserResponse response = userService.createUser(userDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> updateUser(@RequestHeader String token, @RequestBody UserDto userDto, @PathVariable Long userId){
        UserResponse response = userService.updateUser(userId, token, userDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/getuserdata")
    public ResponseEntity<List<?>> getUserData(@RequestParam String token){
        List<UserModel> response = userService.getUserData(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/deleteuser")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Long userId, @RequestHeader String token){
        UserResponse response = userService.deleteUser(userId, token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<ResponseToken> login(@RequestParam String email, @RequestParam String password){
        ResponseToken responseToken = userService.login(email, password);
        return new ResponseEntity<>(responseToken, HttpStatus.OK);
    }
    @GetMapping("/verify")
    public ResponseEntity<UserResponse> verify(@RequestParam String token){
        UserResponse response = userService.verify(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/resetpassword")
    public ResponseEntity<UserResponse> resetPassword(@RequestBody String resetPassword, @PathVariable String token){
        UserResponse response = userService.resetPassword(resetPassword, token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/forgotpassword")
    public ResponseEntity<UserResponse> forgotPassword(@RequestParam String emailId){
        UserResponse response = userService.forgotPassword(emailId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/sendotp")
    public ResponseEntity<UserResponse> sendOtp(@RequestHeader String token) {
        UserResponse response = userService.sendOtp(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/verifyotp/{otp}")
    public ResponseEntity<UserResponse> validateOtp(@PathVariable Long otp, @RequestHeader String token) {
        UserResponse response = userService.validateOtp(otp, token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/purchasesubscription")
    public ResponseEntity<UserResponse> purchaseSubscription(@RequestHeader String token) {
        UserResponse response = userService.purchaseSubscription(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/validate/{token}")
    public Boolean validate(@PathVariable String token){
        return userService.validate(token);
    }
}
