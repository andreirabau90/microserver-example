package com.example.usersapi.controller;


import com.example.usersapi.dto.UserDto;
import com.example.usersapi.mapper.UserMapper;
import com.example.usersapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/getUserById")
    public UserDto getUserById(@RequestParam("id") Long userId) {
        return UserMapper.INSTANCE.userToUserDto(userService.getUserById(userId));
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody UserDto userDto) {
        userService.createUser(UserMapper.INSTANCE.userDtoToUser(userDto));
    }
}
