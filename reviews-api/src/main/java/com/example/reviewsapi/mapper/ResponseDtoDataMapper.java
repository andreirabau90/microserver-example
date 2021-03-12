package com.example.reviewsapi.mapper;

import com.example.reviewsapi.dto.ResponseDto;
import com.example.reviewsapi.entity.Review;
import com.example.reviewsapi.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResponseDtoDataMapper {

    ResponseDtoDataMapper INSTANCE= Mappers.getMapper(ResponseDtoDataMapper.class);

    @Mapping(source = "review.rating",target = "userRating")
    @Mapping(source = "review.comment",target = "userComment")
    ResponseDto.ResponseData mapToResponseData(Review review, Movie movie);
}
