package com.example.reviewsapi.service;

import com.example.reviewsapi.dto.ResponseDto;
import com.example.reviewsapi.entity.Review;

public interface ReviewService {

    ResponseDto getAllReviewsByUserId(Long userId);

    void createReview(Review review);
}
