package com.postech30.movies.mapper;

import com.postech30.movies.dto.FavoriteVideoDTO;
import com.postech30.movies.entity.FavoriteVideo;

public class FavoriteVideoMapper {

    public static FavoriteVideoDTO mapToFavoriteVideoDTO(FavoriteVideo favoriteVideo) {
        return FavoriteVideoDTO.builder()
                .videoId(favoriteVideo.getVideoId())
                .userId(favoriteVideo.getUserId())
                .build();
    }
    public static FavoriteVideo mapToFavoriteVideo(FavoriteVideoDTO favoriteVideoDTO) {
        return new FavoriteVideo(
                favoriteVideoDTO.getVideoId(),
                favoriteVideoDTO.getUserId()
        );
    }

}
