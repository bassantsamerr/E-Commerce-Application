package com.example.wallet_service.controller;

import com.example.wallet_service.entity.User;
import com.example.wallet_service.exception.ErrorResponse;
import com.example.wallet_service.exception.UserAlreadyExistsException;
import com.example.wallet_service.exception.UserWalletInformationNotExistsAtWalletProviderException;
import com.example.wallet_service.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;
    public UserController() {

    }
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
    @ExceptionHandler(value = UserWalletInformationNotExistsAtWalletProviderException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleUserWalletInformationNotExistsAtWalletProviderException(UserWalletInformationNotExistsAtWalletProviderException ex) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
    }
    @ExceptionHandler(value = UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
    }
    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        return userServiceImpl.SignUp(user);
    }
}
