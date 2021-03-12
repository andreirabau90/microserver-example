package com.example.reviewsapi.client;


import com.example.reviewsapi.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "users-api", url = "http://localhost:8081")
public interface UserClient {

    @GetMapping("/getUserById")
    User getUserById(@RequestParam("id") Long userId);
}
