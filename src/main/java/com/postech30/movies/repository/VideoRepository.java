package com.postech30.movies.repository;

import com.postech30.movies.entity.Video;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface VideoRepository extends ReactiveMongoRepository<Video, String> {

    Mono<Video> findByTitleIgnoreCaseContaining(String title);

    Flux<Video> findByPublishDate(LocalDate publishDate);
}
