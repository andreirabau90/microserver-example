package com.example.reviewsapi.mapper;


import com.example.reviewsapi.dto.ResponseDto;
import com.example.reviewsapi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResponseDtoMapper {

    ResponseDtoMapper INSTANCE = Mappers.getMapper(ResponseDtoMapper.class);
    ResponseDto mapUserToResponseDto(User user);
}
