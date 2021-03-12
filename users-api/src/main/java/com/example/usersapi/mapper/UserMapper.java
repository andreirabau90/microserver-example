package com.example.usersapi.mapper;

import com.example.usersapi.dto.UserDto;
import com.example.usersapi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}
