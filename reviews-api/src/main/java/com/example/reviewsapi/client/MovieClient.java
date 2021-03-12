package com.example.reviewsapi.client;

import com.example.reviewsapi.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "movie-api",url = "http://localhost:8082")
public interface MovieClient {

    @GetMapping("/getMovieById")
    Movie getMovieById(@RequestParam("id") Long movieId);
}
