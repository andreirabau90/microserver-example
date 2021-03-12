package com.example.reviewsapi.dto;

import lombok.Data;

@Data
public class RequestReviewDto {

    private Double userRating;
    private String userComment;
}
