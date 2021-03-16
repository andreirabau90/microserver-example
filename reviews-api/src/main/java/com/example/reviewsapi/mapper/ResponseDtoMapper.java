package com.example.reviewsapi.mapper;


import com.example.reviewsapi.dto.ResponseDto;
import com.example.reviewsapi.entity.Review;
import com.example.reviewsapi.model.Movie;
import com.example.reviewsapi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ResponseDtoMapper {

    ResponseDtoMapper INSTANCE = Mappers.getMapper(ResponseDtoMapper.class);

    ResponseDto mapToResponseDto(User user, List<ResponseDto.ResponseData> movies);

    ResponseDto.ResponseData mapToDataResponseDto(Review review, Movie movie);
}
