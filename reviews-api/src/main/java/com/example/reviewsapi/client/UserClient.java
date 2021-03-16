package com.example.reviewsapi.client;


import com.example.reviewsapi.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users-api", url = "http://localhost:8081/users")
public interface UserClient {

    @GetMapping("/{id}")
    User getUserById(@PathVariable("id") Long userId);
}
