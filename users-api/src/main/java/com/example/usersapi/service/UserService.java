package com.example.usersapi.service;

import com.example.usersapi.dto.UserDto;

public interface UserService {
    UserDto getUserById(Long userId);

    void createUser(UserDto userDto);
}
