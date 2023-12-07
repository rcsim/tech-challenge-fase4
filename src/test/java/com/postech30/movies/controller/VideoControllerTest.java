package com.postech30.movies.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.postech30.movies.dto.VideoDTO;
import com.postech30.movies.entity.Video;
import com.postech30.movies.repository.VideoRepository;
import com.postech30.movies.service.Impl.VideoServiceImpl;
import com.postech30.movies.service.VideoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {VideoController.class})
@ExtendWith(SpringExtension.class)
class VideoControllerTest {
    @Autowired
    private VideoController videoController;

    @MockBean
    private VideoService videoService;

    /**
     * Method under test: {@link VideoController#getAllVideos()}
     */
    @Test
    void testGetAllVideos() {
        VideoRepository videoRepository = mock(VideoRepository.class);
        Flux<Video> fromIterableResult = Flux.fromIterable(new ArrayList<>());
        when(videoRepository.findAll()).thenReturn(fromIterableResult);
        (new VideoController(new VideoServiceImpl(videoRepository))).getAllVideos();
        verify(videoRepository).findAll();
    }

    /**
     * Method under test: {@link VideoController#getVideo(String)}
     */
    @Test
    void testGetVideo() {
        VideoRepository videoRepository = mock(VideoRepository.class);
        Mono<Video> justResult = Mono.just(new Video());
        when(videoRepository.findById(Mockito.<String>any())).thenReturn(justResult);
        (new VideoController(new VideoServiceImpl(videoRepository))).getVideo("42");
        verify(videoRepository).findById(Mockito.<String>any());
    }

    /**
     * Method under test: {@link VideoController#getVideoByTitle(String)}
     */
    @Test
    void testGetVideoByTitle() {
        VideoRepository videoRepository = mock(VideoRepository.class);
        Mono<Video> justResult = Mono.just(new Video());
        when(videoRepository.findByTitle(Mockito.any())).thenReturn(justResult);
        (new VideoController(new VideoServiceImpl(videoRepository))).getVideoByTitle("Dr");
        verify(videoRepository).findByTitle(Mockito.any());
    }

    /**
     * Method under test: {@link VideoController#getVideoByPublishDate(LocalDate)}
     */
    @Test
    void testGetVideoByPublishDate() {
        VideoRepository videoRepository = mock(VideoRepository.class);
        Flux<Video> fromIterableResult = Flux.fromIterable(new ArrayList<>());
        when(videoRepository.findByPublishDate(Mockito.any())).thenReturn(fromIterableResult);
        VideoController videoController = new VideoController(new VideoServiceImpl(videoRepository));
        videoController.getVideoByPublishDate(LocalDate.of(1970, 1, 1));
        verify(videoRepository).findByPublishDate(Mockito.any());
    }

    /**
     * Method under test: {@link VideoController#saveVideo(VideoDTO)}
     */
    @Test
    void testSaveVideo() {
        VideoRepository videoRepository = mock(VideoRepository.class);
        Mono<Video> justResult = Mono.just(new Video());
        when(videoRepository.save(Mockito.any())).thenReturn(justResult);
        VideoController videoController = new VideoController(new VideoServiceImpl(videoRepository));
        videoController.saveVideo(new VideoDTO());
        verify(videoRepository).save(Mockito.any());
    }

    /**
     * Method under test: {@link VideoController#updateVideo(VideoDTO, String)}
     */
    @Test
    void testUpdateVideo() throws Exception {
        VideoDTO.VideoDTOBuilder idResult = VideoDTO.builder()
                .description("The characteristics of someone or something")
                .id("42");
        VideoDTO buildResult = idResult.publishDate(LocalDate.of(1970, 1, 1))
                .title("Dr")
                .url("https://example.org/example")
                .build();
        Mono<VideoDTO> justResult = Mono.just(buildResult);
        when(videoService.updateVideo(Mockito.any(), Mockito.any())).thenReturn(justResult);

        VideoDTO videoDTO = new VideoDTO();
        videoDTO.setDescription("The characteristics of someone or something");
        videoDTO.setId("42");
        videoDTO.setPublishDate(null);
        videoDTO.setTitle("Dr");
        videoDTO.setUrl("https://example.org/example");
        String content = (new ObjectMapper()).writeValueAsString(videoDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/videos/{id}", "42")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(videoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link VideoController#deleteVideo(String)}
     */
    @Test
    void testDeleteVideo() {
        VideoRepository videoRepository = mock(VideoRepository.class);
        Flux<?> source = Flux.fromIterable(new ArrayList<>());
        ChannelSendOperator<Object> channelSendOperator = new ChannelSendOperator<>(source, mock(Function.class));

        when(videoRepository.deleteById(Mockito.<String>any())).thenReturn(channelSendOperator);
        Mono<Void> actualDeleteVideoResult = (new VideoController(new VideoServiceImpl(videoRepository))).deleteVideo("42");
        verify(videoRepository).deleteById(Mockito.<String>any());
        assertSame(channelSendOperator, actualDeleteVideoResult);
    }
}
