package com.example.wallet_service.service;

import com.example.wallet_service.entity.User;

public interface UserService {
public User SignUp ( User user);
boolean checkUserExist(User user);
}
