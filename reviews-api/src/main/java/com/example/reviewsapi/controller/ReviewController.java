package com.example.reviewsapi.controller;

import com.example.reviewsapi.dto.RequestReviewDto;
import com.example.reviewsapi.dto.ResponseDto;
import com.example.reviewsapi.mapper.ReviewMapper;
import com.example.reviewsapi.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/getAllReviewsByUserId")
    public ResponseDto getAllReviewsByUserId(@RequestParam("id") Long userId) {
        return reviewService.getAllReviewsByUserId(userId);
    }

    @PostMapping("/createReview")
    public void createReviews(@RequestParam Long userId,
                              @RequestParam Long movieId,
                              @RequestBody RequestReviewDto requestReviewDto) {
        reviewService.createReview(ReviewMapper.INSTANCE.mapToReview(userId, movieId, requestReviewDto));
    }
}
