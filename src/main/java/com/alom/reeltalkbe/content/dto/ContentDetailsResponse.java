package com.alom.reeltalkbe.content.dto;

import com.alom.reeltalkbe.content.domain.Character;
import com.alom.reeltalkbe.content.domain.Content;
import com.alom.reeltalkbe.review.domain.Review;
import com.alom.reeltalkbe.talk.domain.TalkMessage;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Getter
public class ContentDetailsResponse {

    @JsonUnwrapped      //content 라는 json 틀에 안묶이게 함
    private final Content content;

    //private final List<Character> characters;
    private final List<Review> reviews;
    private final List<TalkMessage> talks;

    @Builder
    private ContentDetailsResponse(Content content, List<Review> reviews, List<TalkMessage> talks) {
        this.content = content;
//      this.characters = characters;
        this.reviews = reviews;
        this.talks = talks;
    }

    public static ContentDetailsResponse of(Content content, List<Review> reviews, List<TalkMessage> talks) {
        return ContentDetailsResponse.builder()
                .content(content)
//              .characters(characters)
                .reviews(reviews)
                .talks(talks)
                .build();
    }
}
