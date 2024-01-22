package com.postech30.movies.repository;

import com.postech30.movies.entity.FavoriteVideo;
import com.postech30.movies.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface FavoriteVideoRepository extends ReactiveMongoRepository<FavoriteVideo, String> {

    // Mono<FavoriteVideo> deleteByVideoIdAndUserId(String videoId, String userId);
}
