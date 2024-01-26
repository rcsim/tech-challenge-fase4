package com.postech30.movies.mapper;

import com.postech30.movies.dto.VideoDTO;
import com.postech30.movies.entity.Video;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VideoMapper {

    private static final Logger logger = LoggerFactory.getLogger(VideoMapper.class);
    public static VideoDTO mapToVideoDTO(Video video) {
        return VideoDTO.builder()
                .id(video.getId())
                .title(video.getTitle())
                .description(video.getDescription())
                .url(video.getUrl())
                .publishDate(video.getPublishDate())
                .views(video.getViews())
                .favoritedBy(video.getFavoritedBy())
                .categoryName(video.getCategoryName())
                .categoryDescription(video.getCategoryDescription())
                .build();
    }

    public static Video mapToVideo(VideoDTO videoDTO) {
        return new Video(
                videoDTO.getId(),
                videoDTO.getTitle(),
                videoDTO.getDescription(),
                videoDTO.getUrl(),
                videoDTO.getPublishDate(),
                videoDTO.getViews(),
                videoDTO.getFavoritedBy(),
                videoDTO.getCategory(),
                videoDTO.getCategoryName(),
                videoDTO.getCategoryDescription()
        );
    }
}
