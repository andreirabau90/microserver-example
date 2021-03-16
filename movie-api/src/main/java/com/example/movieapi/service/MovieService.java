package com.example.movieapi.service;

import com.example.movieapi.dto.MovieDto;

public interface MovieService {

    MovieDto getMovieById(Long movieId);

    void createMovie(MovieDto movieDto);
}
