package com.alom.reeltalkbe.content.repository;


import com.alom.reeltalkbe.content.domain.Content;
import java.time.LocalDate;

import com.alom.reeltalkbe.content.domain.ContentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {

    List<Content> findTop10ByContentTypeOrderByReleaseDateDesc(ContentType contentType);
    List<Content> findTop10ByContentTypeOrderByRatingAverageDesc(ContentType contentType);
    List<Content> findTop10ByContentTypeAndReleaseDateBetweenOrderByPopularityDesc(ContentType contentType, LocalDate today, LocalDate monthLater);
    List<Content> findTop10ByContentTypeAndReleaseDateAfterOrderByReleaseDateAsc(ContentType contentType, LocalDate today);
    List<Content> findTop3ByOrderByRatingAverageDesc();

    List<Content> findTop10ByContentTypeOrderByReleaseDateAsc(ContentType contentType);

    List<Content> findByContentTypeOrderByRatingAverageDesc(ContentType contentType);

    // releaseDate가 오늘 이전인 컨텐츠(내림차순)
    List<Content> findByContentTypeAndReleaseDateBeforeOrderByReleaseDateDesc(ContentType contentType, LocalDate date);

    // releaseDate가 오늘 이후인 컨텐츠(오름차순)
    List<Content> findByContentTypeAndReleaseDateAfterOrderByReleaseDateAsc(ContentType contentType, LocalDate date);

    // 기존에 존재하는 TV 시리즈의 제목과 개봉일 조회
    @Query("SELECT c.enTitle, c.releaseDate FROM Content c WHERE c.enTitle IN :titles AND c.releaseDate IN :dates")
    List<Object[]> findExistingTitles(@Param("titles") List<String> titles, @Param("dates") List<LocalDate> dates);
}
