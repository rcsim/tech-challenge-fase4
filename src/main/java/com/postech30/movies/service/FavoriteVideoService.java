package com.postech30.movies.service;

import com.postech30.movies.dto.FavoriteVideoDTO;
import reactor.core.publisher.Mono;

public interface FavoriteVideoService {

    Mono<FavoriteVideoDTO> addFavoriteVideo(FavoriteVideoDTO favoriteVideoDTO );

    // Mono<Void> removeFavoriteVideo(String videoId, String userId);
}
