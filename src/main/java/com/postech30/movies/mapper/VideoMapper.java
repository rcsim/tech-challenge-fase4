package com.postech30.movies.mapper;

import com.postech30.movies.dto.VideoDTO;
import com.postech30.movies.entity.Video;

public class VideoMapper {

    public static VideoDTO mapToVideoDTO(Video video) {
        return VideoDTO.builder()
                .id(video.getId())
                .title(video.getTitle())
                .description(video.getDescription())
                .url(video.getUrl())
                .publishDate(video.getPublishDate())
                .build();
    }

    public static Video mapToVideo(VideoDTO videoDTO) {
        return new Video(
                videoDTO.getId(),
                videoDTO.getTitle(),
                videoDTO.getDescription(),
                videoDTO.getUrl(),
                videoDTO.getPublishDate()
        );
    }
}
