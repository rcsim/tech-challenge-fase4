package com.postech30.movies.service.Impl;

import com.amazonaws.services.s3.AmazonS3;
import com.postech30.movies.dto.VideoDTO;
import com.postech30.movies.entity.Category;
import com.postech30.movies.entity.Video;
import com.postech30.movies.repository.UserRepository;
import com.postech30.movies.repository.VideoRepository;
import com.postech30.movies.service.AwsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {VideoServiceImpl.class})
@ExtendWith(SpringExtension.class)
class VideoServiceImplTest {
    @MockBean
    private VideoRepository videoRepository;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private VideoServiceImpl videoServiceImpl;

    @MockBean
    private ReactiveMongoTemplate reactiveMongoTemplate;




    /**
     * Method under test: {@link VideoServiceImpl#getAllVideos(Pageable)}
     */
    @Test
    void testGetAllVideos() {
        // Given
        Video video = new Video();
        video.setId("42");
        video.setTitle("Dr");
        // Add other properties as needed...

        Flux<Video> videoFlux = Flux.just(video);

        Pageable pageable = PageRequest.of(0, 10); // First page, 10 items per page

        when(reactiveMongoTemplate.aggregate(any(Aggregation.class), eq("videos"), eq(Video.class)))
                .thenReturn(videoFlux);

        // When
        Flux<VideoDTO> result = videoServiceImpl.getAllVideos(pageable);

        // Then
        StepVerifier.create(result)
                .expectNextMatches(videoDTO -> videoDTO.getId().equals(video.getId()) &&
                        videoDTO.getTitle().equals(video.getTitle()))
                // Add other assertions as needed...
                .verifyComplete();

        verify(reactiveMongoTemplate).aggregate(any(Aggregation.class), eq("videos"), eq(Video.class));
    }

//    /**
//     * Method under test: {@link VideoServiceImpl#getAllVideos()}
//     */
//    @Test
//    void testGetAllVideos2() {
//        Video video = new Video();
//        video.setDescription("The characteristics of someone or something");
//        video.setId("42");
//        video.setPublishDate(LocalDate.of(1970, 1, 1));
//        video.setTitle("Dr");
//        video.setCategoryName("Action");
//        video.setCategoryDescription("Action movies involve instances of physical action such as fights, stunts, car chases, etc.");
//        video.setUrl("https://example.org/example");
//
//        ArrayList<Video> it = new ArrayList<>();
//        it.add(video);
//        Flux<Video> fromIterableResult = Flux.fromIterable(it);
//        when(videoRepository.findAll()).thenReturn(fromIterableResult);
//        videoServiceImpl.getAllVideos();
//        verify(videoRepository).findAll();
//    }
//
//    /**
//     * Method under test: {@link VideoServiceImpl#getAllVideos()}
//     */
//    @Test
//    void testGetAllVideos3() {
//        DirectProcessor<Video> createResult = DirectProcessor.create();
//        when(videoRepository.findAll()).thenReturn(createResult);
//        videoServiceImpl.getAllVideos();
//        verify(videoRepository).findAll();
//    }

    /**
     * Method under test: {@link VideoServiceImpl#getVideo(String)}
     */
    @Test
    void testGetVideo() {
        Mono<Video> justResult = Mono.just(new Video());
        when(videoRepository.findById(Mockito.<String>any())).thenReturn(justResult);
        videoServiceImpl.getVideo("42");
        verify(videoRepository).findById(Mockito.<String>any());
    }

    /**
     * Method under test: {@link VideoServiceImpl#getVideoByTitle(String)}
     */
    @Test
    void testGetVideoByTitle() {
        Mono<Video> justResult = Mono.just(new Video());
        when(videoRepository.findByTitleIgnoreCaseContaining(Mockito.any())).thenReturn(justResult);
        videoServiceImpl.getVideoByTitle("Dr");
        verify(videoRepository).findByTitleIgnoreCaseContaining(Mockito.any());
    }

    /**
     * Method under test: {@link VideoServiceImpl#getVideoByPublishDate(LocalDate)}
     */
    @Test
    void testGetVideoByPublishDate() {
        Flux<Video> fromIterableResult = Flux.fromIterable(new ArrayList<>());
        when(videoRepository.findByPublishDate(Mockito.any())).thenReturn(fromIterableResult);
        videoServiceImpl.getVideoByPublishDate(LocalDate.of(1970, 1, 1));
        verify(videoRepository).findByPublishDate(Mockito.any());
    }

    /**
     * Method under test: {@link VideoServiceImpl#getVideoByPublishDate(LocalDate)}
     */
    @Test
    void testGetVideoByPublishDate2() {
        DirectProcessor<Video> createResult = DirectProcessor.create();
        when(videoRepository.findByPublishDate(Mockito.any())).thenReturn(createResult);
        videoServiceImpl.getVideoByPublishDate(LocalDate.of(1970, 1, 1));
        verify(videoRepository).findByPublishDate(Mockito.any());
    }

    /**
     * Method under test: {@link VideoServiceImpl#getVideoByCategory(String)}
     */
    @Test
    void testGetVideoByCategory() {
        // Given
        String categoryName = "Horror";
        Video video = new Video();
        video.setId("42");
        video.setTitle("Dr");
        // Add other properties as needed...

        Flux<Video> videoFlux = Flux.just(video);

        when(reactiveMongoTemplate.aggregate(any(Aggregation.class), eq("videos"), eq(Video.class)))
                .thenReturn(videoFlux);

        // When
        Flux<VideoDTO> result = videoServiceImpl.getVideoByCategory(categoryName);

        // Then
        StepVerifier.create(result)
                .expectNextMatches(videoDTO -> videoDTO.getId().equals(video.getId()) &&
                        videoDTO.getTitle().equals(video.getTitle()))
                // Add other assertions as needed...
                .verifyComplete();

        verify(reactiveMongoTemplate).aggregate(any(Aggregation.class), eq("videos"), eq(Video.class));
    }

    /**
     * Method under test: {@link VideoServiceImpl#saveVideo(VideoDTO)}
     */
    @Test
    void testSaveVideo() {
        Mono<Video> justResult = Mono.just(new Video());
        when(videoRepository.save(Mockito.any())).thenReturn(justResult);
        videoServiceImpl.saveVideo(new VideoDTO());
        verify(videoRepository).save(Mockito.any());
    }

    /**
     * Method under test: {@link VideoServiceImpl#updateVideo(VideoDTO, String)}
     */
    @Test
    void testUpdateVideo() {
        Mono<Video> justResult = Mono.just(new Video());
        when(videoRepository.findById(Mockito.<String>any())).thenReturn(justResult);
        videoServiceImpl.updateVideo(new VideoDTO(), "42");
        verify(videoRepository).findById(Mockito.<String>any());
    }

    /**
     * Method under test: {@link VideoServiceImpl#deleteVideo(String)}
     */
    @Test
    void testDeleteVideo() {
        Flux<?> source = Flux.fromIterable(new ArrayList<>());
        ChannelSendOperator<Object> channelSendOperator = new ChannelSendOperator<>(source, mock(Function.class));

        when(videoRepository.deleteById(Mockito.<String>any())).thenReturn(channelSendOperator);
        Mono<Void> actualDeleteVideoResult = videoServiceImpl.deleteVideo("42");
        verify(videoRepository).deleteById(Mockito.<String>any());
        assertSame(channelSendOperator, actualDeleteVideoResult);
    }
}
