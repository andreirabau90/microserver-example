package com.example.usersapi.service.impl;

import com.example.usersapi.entity.User;
import com.example.usersapi.repository.UserRepository;
import com.example.usersapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(() ->new EntityNotFoundException(String.format("entity with id= :%s not found" ,userId)));
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userRepository.save(user);
    }
}
