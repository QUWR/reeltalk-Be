package com.alom.reeltalkbe.content.controller;


import com.alom.reeltalkbe.common.response.BaseResponse;
import com.alom.reeltalkbe.content.domain.Content;
import com.alom.reeltalkbe.content.dto.ContentDetailsResponse;
import com.alom.reeltalkbe.content.dto.MovieTabResponse;
import com.alom.reeltalkbe.content.dto.SeriesTabResponse;
import com.alom.reeltalkbe.content.dto.TMDB.TMDBMovieDetailsRequest;
import com.alom.reeltalkbe.content.dto.TMDB.TMDBSeriesDetailsRequest;
import com.alom.reeltalkbe.content.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ContentController {
    private final ContentService contentService;

    // 메인화면 - 컬렉션 리스트 여러개
    @GetMapping("/browse")
    public BaseResponse<String> getContents(@RequestParam("sort") String sort) {
        contentService.findPopularContents();
        return new BaseResponse<>("흠, 어떡하쥥");
    }

    // 영화 탭
    @GetMapping("/movies")
    public BaseResponse<List<MovieTabResponse>> getMoviesSortBy(@RequestParam("sort") String sort) {
        return new BaseResponse<>(contentService.findMoviesAndReviewsSortBy(sort));
    }

    // todo: 시리즈 탭
    @GetMapping("/series")
    public BaseResponse<List<SeriesTabResponse>> getSeriesSortBy(@RequestParam("sort") String sort) {
        return new BaseResponse<>(contentService.findSeriesAndReviewsSortBy(sort));
    }

    // 컨텐츠 세부 정보 조회
    @GetMapping("/contents/{contentId}")
    public BaseResponse<ContentDetailsResponse> getContentDetails(@PathVariable Long contentId) {
        return new BaseResponse<>(contentService
                .findContentDetailsByContentId(contentId));
    }

    @GetMapping("series/{filter}")
    public BaseResponse<?> getSeriesTopRated(@PathVariable String filter) {
        return new BaseResponse<>(contentService.findSeriesWithReviewsByFilter(filter));
    }


    // --------------- 테스트용 메서드 ----------------------
    // 컨텐츠 생성
    @PostMapping("/contents")
    public BaseResponse<Content> addContents(@RequestBody TMDBMovieDetailsRequest request) {
        return new BaseResponse<>(contentService.addContent(new Content(request)));
    }

    // 시리즈 컨텐츠 생성
    @PostMapping("/contents/series")
    public BaseResponse<Content> addSeriesContents(@RequestBody TMDBSeriesDetailsRequest request) {
        return new BaseResponse<>(contentService.addContent(new Content(request)));
    }

}
