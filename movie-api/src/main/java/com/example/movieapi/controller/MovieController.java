package com.example.movieapi.controller;

import com.example.movieapi.dto.MovieDto;
import com.example.movieapi.mapper.MovieMapper;
import com.example.movieapi.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/getMovieById")
    public MovieDto getMovieById(@RequestParam("id") Long movieId) {
        return MovieMapper.INSTANCE.movieToMovieDto(movieService.getMovieById(movieId));
    }

    @PostMapping("/createMovie")
    public void createMovie(@RequestBody MovieDto movieDto) {
        movieService.createMovie(MovieMapper.INSTANCE.movieDtoToMovie(movieDto));
    }
}
