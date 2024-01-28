package com.postech30.movies.service.Impl;

import com.postech30.movies.dto.FavoriteVideoDTO;
import com.postech30.movies.dto.VideoDTO;
import com.postech30.movies.entity.User;
import com.postech30.movies.entity.Video;
import com.postech30.movies.mapper.VideoMapper;
import com.postech30.movies.repository.UserRepository;
import com.postech30.movies.repository.VideoRepository;
import com.postech30.movies.service.VideoService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

    private VideoRepository videoRepository;
    private UserRepository userRepository;
    private final ReactiveMongoTemplate reactiveMongoTemplate;
    private static final Logger logger = LoggerFactory.getLogger(VideoMapper.class);




    @Override
    public Flux<VideoDTO> getAllVideos(Pageable pageable) {
        List<AggregationOperation> operations = new ArrayList<>();

        // Add sorting operations from pageable
        for (Sort.Order order : pageable.getSort()) {
            operations.add(new SortOperation(Sort.by(order.getDirection(), order.getProperty())));
        }

        // Add paging operations
        operations.add(Aggregation.skip((long) pageable.getPageNumber() * pageable.getPageSize()));
        operations.add(Aggregation.limit(pageable.getPageSize()));

        Flux<Video> videoFlux = reactiveMongoTemplate.aggregate(
                Aggregation.newAggregation(operations),
                "videos",
                Video.class
        );

        return videoFlux.map(VideoMapper::mapToVideoDTO);
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
    public Flux<VideoDTO> getVideosByCategory(String category) {
        Flux<Video> videoMono = videoRepository.findByCategory(new ObjectId(category));
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

    @Override
    public Mono<VideoDTO> favoriteVideo(FavoriteVideoDTO favoriteVideoDTO) {
        Mono<User> userMono = userRepository.findById(favoriteVideoDTO.getUserId())
                .switchIfEmpty(Mono.error(new RuntimeException("Usuário não encontrado ")))
                .flatMap(user -> {
                    if (user.getFavorites() == null) {
                        user.setFavorites(new ArrayList<>());
                    }
                    ObjectId videoId = new ObjectId(favoriteVideoDTO.getVideoId());
                    if (!user.getFavorites().contains(videoId)) {
                        user.getFavorites().add(videoId);
                        return userRepository.save(user);
                    }
                    return Mono.just(user);
                });

        Mono<Video> videoMono = videoRepository.findById(favoriteVideoDTO.getVideoId())
                .switchIfEmpty(Mono.error(new RuntimeException("Video não encontrado")))
                .flatMap(video -> {
                    if (video.getFavoritedBy() == null) {
                        video.setFavoritedBy(new ArrayList<>());
                    }
                    ObjectId userId = new ObjectId(favoriteVideoDTO.getUserId());
                    if (!video.getFavoritedBy().contains(userId)) {
                        video.getFavoritedBy().add(userId);
                        return videoRepository.save(video);
                    }
                    return Mono.just(video);
                });

        return Mono.zip(userMono, videoMono)
                .map(tuple -> VideoMapper.mapToVideoDTO(tuple.getT2()));
    }

    @Override
    public Mono<VideoDTO> unfavoriteVideo(FavoriteVideoDTO favoriteVideoDTO) {
        Mono<User> userMono = userRepository.findById(favoriteVideoDTO.getUserId())
                .switchIfEmpty(Mono.error(new RuntimeException("Usuário não encontrado ")))
                .flatMap(user -> {
                    ObjectId videoId = new ObjectId(favoriteVideoDTO.getVideoId());
                    if (user.getFavorites() != null && user.getFavorites().contains(videoId)) {
                        user.getFavorites().remove(videoId);
                        return userRepository.save(user);
                    }
                    return Mono.just(user);
                });

        Mono<Video> videoMono = videoRepository.findById(favoriteVideoDTO.getVideoId())
                .switchIfEmpty(Mono.error(new RuntimeException("Video não encontrado")))
                .flatMap(video -> {
                    ObjectId userId = new ObjectId(favoriteVideoDTO.getUserId());
                    if (video.getFavoritedBy() != null && video.getFavoritedBy().contains(userId)) {
                        video.getFavoritedBy().remove(userId);
                        return videoRepository.save(video);
                    }
                    return Mono.just(video);
                });

        return Mono.zip(userMono, videoMono)
                .map(tuple -> VideoMapper.mapToVideoDTO(tuple.getT2()));
    }
}
