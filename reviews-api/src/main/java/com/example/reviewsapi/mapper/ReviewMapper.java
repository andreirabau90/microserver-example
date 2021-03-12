package com.example.reviewsapi.mapper;

import com.example.reviewsapi.dto.RequestReviewDto;
import com.example.reviewsapi.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Lazy;

@Mapper
@Lazy
public interface ReviewMapper {

    ReviewMapper INSTANCE= Mappers.getMapper(ReviewMapper.class);

    @Mapping(source = "requestReviewDto.userRating", target = "rating")
    @Mapping(source = "requestReviewDto.userComment", target = "comment")
    Review mapToReview(Long userId, Long movieId, RequestReviewDto requestReviewDto);
}
