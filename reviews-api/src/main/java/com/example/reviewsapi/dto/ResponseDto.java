package com.example.reviewsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private String firstName;
    private String lastName;
    private String email;
    private List<ResponseData> movies;

    @Data
    public static class ResponseData {
        private String title;
        private String directorName;
        private Date releaseDate;
        private Double userRating;
        private String userComment;
    }
}
