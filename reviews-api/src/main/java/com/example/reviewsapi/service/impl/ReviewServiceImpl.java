package com.example.reviewsapi.service.impl;

import com.example.reviewsapi.client.MovieClient;
import com.example.reviewsapi.client.UserClient;
import com.example.reviewsapi.dto.RequestReviewDto;
import com.example.reviewsapi.dto.ResponseDto;
import com.example.reviewsapi.entity.Review;
import com.example.reviewsapi.mapper.ResponseDtoMapper;
import com.example.reviewsapi.mapper.ReviewMapper;
import com.example.reviewsapi.model.User;
import com.example.reviewsapi.repository.ReviewRepository;
import com.example.reviewsapi.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final UserClient userClient;
    private final MovieClient movieClient;
    private final ReviewRepository reviewRepository;

    @Override
    public ResponseDto getAllReviewsByUserId(Long userId) {
        ExecutorService service = Executors.newScheduledThreadPool(10);
        CompletableFuture<List<Review>> reviews = CompletableFuture
                .supplyAsync(() -> reviewRepository.findAllByUserId(userId), service);

        CompletableFuture<User> user = CompletableFuture
                .supplyAsync(() -> userClient.getUserById(userId), service);

        List<ResponseDto.ResponseData> dataList = reviews.join().stream()
                .map(review -> CompletableFuture.supplyAsync(() -> movieClient.getMovieById(review.getMovieId()), service)
                        .thenApplyAsync(movie -> ResponseDtoMapper.INSTANCE.mapToDataResponseDto(review, movie)))
                .parallel()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        return ResponseDtoMapper.INSTANCE.mapToResponseDto(user.join(), dataList);
    }

    @Override
    @Transactional
    public void createReview(Long userId, Long movieId, RequestReviewDto requestReviewDto) {
        reviewRepository.save(ReviewMapper.INSTANCE.mapToReview(userId, movieId, requestReviewDto));
    }
}
