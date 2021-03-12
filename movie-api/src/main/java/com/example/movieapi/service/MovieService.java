package com.example.movieapi.service;

import com.example.movieapi.entity.Movie;

public interface MovieService {

    Movie getMovieById(Long movieId);
    void createMovie(Movie movie);
}
