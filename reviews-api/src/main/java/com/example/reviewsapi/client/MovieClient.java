package com.example.reviewsapi.client;

import com.example.reviewsapi.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie-api", url = "http://localhost:8082/movies")
public interface MovieClient {

    @GetMapping("/{id}")
    Movie getMovieById(@PathVariable("id") Long movieId);
}
