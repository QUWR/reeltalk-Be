package com.alom.reeltalkbe.review.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewSummaryDto {

    private Long reviewId;
    private Long contentId;
    private Long userId;
    private Long imageId;

    private Float rating;
    private String createAt;
    private String updateAt;
}
