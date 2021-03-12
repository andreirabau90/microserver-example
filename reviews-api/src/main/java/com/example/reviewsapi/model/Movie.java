package com.example.reviewsapi.model;

import lombok.Data;

import java.util.Date;

@Data
public class Movie {

    private String title;
    private String directorName;
    private Date releaseDate;
}
