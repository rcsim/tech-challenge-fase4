package com.postech30.movies.service;

import com.postech30.movies.dto.CategoryDTO;
import com.postech30.movies.dto.VideoDTO;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.LocalDate;

public interface VideoService {

    Flux<VideoDTO> getAllVideos(Pageable pageable);

    Mono<VideoDTO> getVideo(String videoId);

    Mono<VideoDTO> getVideoByTitle(String title);

    Flux<VideoDTO> getVideoByPublishDate(LocalDate publishDate);

    Flux<VideoDTO> getVideoByCategory(String categoryName);

    Mono<VideoDTO> saveVideo(VideoDTO videoDTO);

    Mono<VideoDTO> updateVideo(VideoDTO videoDTO, String videoId);

    Mono<Void> deleteVideo(String videoId);


}
