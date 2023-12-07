package com.postech30.movies.service.Impl;

import com.postech30.movies.dto.VideoDTO;
import com.postech30.movies.entity.Video;
import com.postech30.movies.repository.VideoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @Autowired
    private VideoServiceImpl videoServiceImpl;

    /**
     * Method under test: {@link VideoServiceImpl#getAllVideos()}
     */
    @Test
    void testGetAllVideos() {
        Flux<Video> fromIterableResult = Flux.fromIterable(new ArrayList<>());
        when(videoRepository.findAll()).thenReturn(fromIterableResult);
        videoServiceImpl.getAllVideos();
        verify(videoRepository).findAll();
    }

    /**
     * Method under test: {@link VideoServiceImpl#getAllVideos()}
     */
    @Test
    void testGetAllVideos2() {
        Video video = new Video();
        video.setDescription("The characteristics of someone or something");
        video.setId("42");
        video.setPublishDate(LocalDate.of(1970, 1, 1));
        video.setTitle("Dr");
        video.setUrl("https://example.org/example");

        ArrayList<Video> it = new ArrayList<>();
        it.add(video);
        Flux<Video> fromIterableResult = Flux.fromIterable(it);
        when(videoRepository.findAll()).thenReturn(fromIterableResult);
        videoServiceImpl.getAllVideos();
        verify(videoRepository).findAll();
    }

    /**
     * Method under test: {@link VideoServiceImpl#getAllVideos()}
     */
    @Test
    void testGetAllVideos3() {
        DirectProcessor<Video> createResult = DirectProcessor.create();
        when(videoRepository.findAll()).thenReturn(createResult);
        videoServiceImpl.getAllVideos();
        verify(videoRepository).findAll();
    }

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
        when(videoRepository.findByTitle(Mockito.any())).thenReturn(justResult);
        videoServiceImpl.getVideoByTitle("Dr");
        verify(videoRepository).findByTitle(Mockito.any());
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
