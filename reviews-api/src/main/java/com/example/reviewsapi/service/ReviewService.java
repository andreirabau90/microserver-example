package com.example.reviewsapi.service;

import com.example.reviewsapi.dto.RequestReviewDto;
import com.example.reviewsapi.dto.ResponseDto;

public interface ReviewService {

    ResponseDto getAllReviewsByUserId(Long userId);

    void createReview(Long userId, Long molieId, RequestReviewDto requestReviewDto);
}
