package com.example.usersapi.service;

import com.example.usersapi.entity.User;

public interface UserService {
    User getUserById(long userId);
    void createUser(User userDtoToUser);
}
