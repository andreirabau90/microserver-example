package com.example.movieapi.service.impl;

import com.example.movieapi.entity.Movie;
import com.example.movieapi.repository.MovieRepository;
import com.example.movieapi.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId).orElseThrow(() ->new EntityNotFoundException(String.format("entity with id= :%s not found" ,movieId)));
    }

    @Override
    @Transactional
    public void createMovie(Movie movie) {
        movieRepository.save(movie);
    }
}
