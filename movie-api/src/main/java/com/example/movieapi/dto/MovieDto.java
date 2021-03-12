package com.example.movieapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MovieDto {
    private String title;
    private String directorName;
    private Date releaseDate;
}
