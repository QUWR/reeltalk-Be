package com.alom.reeltalkbe.content.dto;

import com.alom.reeltalkbe.content.domain.Content;
import com.alom.reeltalkbe.content.domain.Genre;
import com.alom.reeltalkbe.content.domain.GenreListConverter;
import com.alom.reeltalkbe.review.domain.Review;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Convert;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MovieTabResponse {

    private Long id;
    private boolean adult;

    @JsonProperty("backdrop_path")
    private String backdropPath;

    @Convert(converter = GenreListConverter.class)
    @JsonProperty("genres")
    private List<Genre> genres; // MovieDetails랑 같게 세팅, id만 따로 안해도 되면 이게 편함

    private String overview;
    private double popularity;
    private double rating;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("release_date")
    private LocalDate releaseDate;

    private String title;

    private List<ReviewResponse> reviews;

    @Builder
    private MovieTabResponse(Content content, List<ReviewResponse> reviews) {
        id = content.getId();
        adult = content.isAdult();
        backdropPath = content.getBackdropPath();
        genres = content.getGenres();
        overview = content.getOverview();
        popularity = content.getPopularity();
        rating = content.getRatingAverage();
        posterPath = content.getPosterPath();
        releaseDate = content.getReleaseDate();
        title = content.getEnTitle();
        this.reviews = reviews;
    }

    public static MovieTabResponse of(Content content, List<Review> reviews) {
        List<ReviewResponse> reviewResponses = reviews.stream()
            .map(ReviewResponse::of)
            .toList();

        return MovieTabResponse.builder()
                .content(content)
                .reviews(reviewResponses)
                .build();
    }
}
