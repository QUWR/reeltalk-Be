package com.alom.reeltalkbe.comment.dto;


import com.alom.reeltalkbe.comment.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDTO {

    private Long id;
    private String user;
    private String userImg;
    private Long reviewId;
    private String content;
    private int likeCount;
    private LocalDateTime createAt;


    public CommentResponseDTO(Comment comment) {
        id = comment.getId();
        user = comment.getUser().getUsername();
        userImg = comment.getUser().getImageUrl();
        reviewId = comment.getReview().getId();
        content = comment.getContent();
        likeCount = comment.getLikeCount();
        createAt = comment.getCreatedAt();
    }
}
