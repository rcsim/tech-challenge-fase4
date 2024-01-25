package com.postech30.movies.mapper;

import com.postech30.movies.dto.VideoDTO;
import com.postech30.movies.entity.Video;
import org.bson.types.ObjectId;

import java.util.stream.Collectors;

public class VideoMapper {


    public static VideoDTO mapToVideoDTO(Video video) {
        return VideoDTO.builder()
                .id(video.getId())
                .title(video.getTitle())
                .description(video.getDescription())
                .url(video.getUrl())
                .publishDate(video.getPublishDate())
                .views(video.getViews())
                .favoritedBy(video.getFavoritedBy() != null ?
                        video.getFavoritedBy().stream()
                                .map(ObjectId::toHexString)
                                .collect(Collectors.toList()) : null)
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
                videoDTO.getFavoritedBy() != null ?
                        videoDTO.getFavoritedBy().stream()
                                .map(ObjectId::new)
                                .collect(Collectors.toList()) : null,
                videoDTO.getCategoryName(),
                videoDTO.getCategoryDescription()
        );
    }
}
