package com.postech30.movies.service.Impl;

import com.postech30.movies.dto.CategoryDTO;
import com.postech30.movies.dto.VideoDTO;
import com.postech30.movies.entity.Video;
import com.postech30.movies.mapper.VideoMapper;
import com.postech30.movies.repository.VideoRepository;
import com.postech30.movies.service.VideoService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

    private VideoRepository videoRepository;
    private final ReactiveMongoTemplate reactiveMongoTemplate;
    private static final Logger logger = LoggerFactory.getLogger(VideoMapper.class);

    @Override
    public Flux<VideoDTO> getAllVideos() {
        Flux<Video> videoFlux = reactiveMongoTemplate.aggregate(
                Aggregation.newAggregation(
                        Aggregation.lookup("categories", "category", "_id", "categoryInfo"),
                        Aggregation.unwind("categoryInfo"),
                        Aggregation.project()
                                .andInclude("_id", "title", "description", "url", "publishDate", "views", "favoritedBy")
                                .and("categoryInfo.name").as("categoryName")
                                .and("categoryInfo.description").as("categoryDescription")
                ),
                "videos",
                Video.class
        );
        return videoFlux.map(VideoMapper::mapToVideoDTO).switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<VideoDTO> getVideo(String videoId) {
        Mono<Video> videoMono = videoRepository.findById(videoId);
        return videoMono.map(VideoMapper::mapToVideoDTO);
    }

    @Override
    public Mono<VideoDTO> getVideoByTitle(String title) {
        Mono<Video> videoMono = videoRepository.findByTitleIgnoreCaseContaining(title);
        return videoMono.map(VideoMapper::mapToVideoDTO);
    }

    @Override
    public Flux<VideoDTO> getVideoByPublishDate(LocalDate publishDate) {
        Flux<Video> videoMono = videoRepository.findByPublishDate(publishDate);
        return videoMono.map(VideoMapper::mapToVideoDTO);
    }

    @Override
    public Flux<VideoDTO> getVideoByCategory(String categoryName) {
        MatchOperation matchStage = Aggregation.match(new Criteria("categoryInfo.name").is(categoryName));

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.lookup("categories", "category", "_id", "categoryInfo"),
                Aggregation.unwind("categoryInfo"),
                matchStage,
                Aggregation.project()
                        .andInclude("_id", "title", "description", "url", "publishDate", "views", "favoritedBy")
                        .and("categoryInfo.name").as("categoryName")
                        .and("categoryInfo.description").as("categoryDescription")
        );

        Flux<Video> videoMono = reactiveMongoTemplate.aggregate(aggregation, "videos", Video.class);
        return videoMono.map(VideoMapper::mapToVideoDTO);
    }

    @Override
    public Mono<VideoDTO> saveVideo(VideoDTO videoDTO) {
        Video video = VideoMapper.mapToVideo(videoDTO);
        Mono<Video> savedVideo = videoRepository.save(video);
        return savedVideo.map(VideoMapper::mapToVideoDTO);
    }

    @Override
    public Mono<VideoDTO> updateVideo(VideoDTO videoDTO, String videoId) {
        Mono<Video> videoMono = videoRepository.findById(videoId);
        return videoMono.flatMap(existingVideo -> {
            existingVideo.setDescription(videoDTO.getDescription());
            existingVideo.setTitle(videoDTO.getTitle());
            existingVideo.setUrl(videoDTO.getUrl());
            existingVideo.setPublishDate(videoDTO.getPublishDate());
            existingVideo.setViews(videoDTO.getViews());
            return videoRepository.save(existingVideo);
        }).map(VideoMapper::mapToVideoDTO);
    }

    @Override
    public Mono<Void> deleteVideo(String videoId) {
        return videoRepository.deleteById(videoId);
    }
}
