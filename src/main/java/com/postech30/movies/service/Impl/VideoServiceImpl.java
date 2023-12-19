package com.postech30.movies.service.Impl;

import com.postech30.movies.dto.VideoDTO;
import com.postech30.movies.entity.Video;
import com.postech30.movies.mapper.VideoMapper;
import com.postech30.movies.repository.VideoRepository;
import com.postech30.movies.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

    private VideoRepository videoRepository;

    @Override
    public Flux<VideoDTO> getAllVideos() {
        Flux<Video> videoFlux = videoRepository.findAll();
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
            return videoRepository.save(existingVideo);
        }).map(VideoMapper::mapToVideoDTO);
    }

    @Override
    public Mono<Void> deleteVideo(String videoId) {
        return videoRepository.deleteById(videoId);
    }
}
