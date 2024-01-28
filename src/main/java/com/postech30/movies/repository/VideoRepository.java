package com.postech30.movies.repository;

import com.postech30.movies.entity.Video;
import org.bson.types.ObjectId;
import org.reactivestreams.Publisher;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

public interface VideoRepository extends ReactiveMongoRepository<Video, String> {

    Mono<Video> findByTitleIgnoreCaseContaining(String title);


    Flux<Video> findByPublishDate(LocalDate publishDate);


    Flux<Video> findByCategory(ObjectId category);


    @Aggregation("{ $count: 'totalVideos' }")
    Mono<Long> getTotalVideos();

    @Query(value = "{ 'favoritedBy': { $ne: null } }", count = true)
    Mono<Long> countAllByFavoritedByNotNull();

    @Aggregation("{ $group: { _id: null, averageViews: { $avg: '$views' } } }")
    Mono<Double> getAverageViews();


    @Query("{ 'category': ?0 }")
    Flux<Video> findVideosByCategory(ObjectId category);
}
