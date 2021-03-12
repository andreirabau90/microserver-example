package com.example.movieapi.mapper;

import com.example.movieapi.dto.MovieDto;
import com.example.movieapi.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

     MovieDto movieToMovieDto(Movie movie);
     Movie movieDtoToMovie(MovieDto movieDto);
}
