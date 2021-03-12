package com.example.reviewsapi.service.impl;

import com.example.reviewsapi.client.MovieClient;
import com.example.reviewsapi.client.UserClient;
import com.example.reviewsapi.dto.ResponseDto;
import com.example.reviewsapi.entity.Review;
import com.example.reviewsapi.mapper.ResponseDtoDataMapper;
import com.example.reviewsapi.mapper.ResponseDtoMapper;
import com.example.reviewsapi.repository.ReviewRepository;
import com.example.reviewsapi.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final UserClient userClient;
    private final MovieClient movieClient;
    private final ReviewRepository reviewRepository;

    @Override
    public ResponseDto getAllReviewsByUserId(Long userId) {
        ResponseDto responseDto = ResponseDtoMapper.INSTANCE.mapUserToResponseDto(userClient.getUserById(userId));
        List<Review> reviews = reviewRepository.findAllByUserId(userId);
        List<ResponseDto.ResponseData> responseDataList = new ArrayList<>();
        for (Review review :
                reviews) {
            ResponseDto.ResponseData data = ResponseDtoDataMapper.INSTANCE.mapToResponseData(
                    review,
                    movieClient.getMovieById(review.getMovieId()));
            responseDataList.add(data);
        }
        responseDto.setMovies(responseDataList);
        return responseDto;
    }

    @Override
    @Transactional
    public void createReview(Review review) {
        reviewRepository.save(review);
    }
}
