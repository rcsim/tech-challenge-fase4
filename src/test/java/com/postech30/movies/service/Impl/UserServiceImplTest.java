package com.postech30.movies.service.Impl;

import com.postech30.movies.dto.UserDTO;
import com.postech30.movies.entity.User;
import com.postech30.movies.entity.Video;
import com.postech30.movies.repository.UserRepository;
import com.postech30.movies.repository.VideoRepository;
import com.postech30.movies.service.UserService;

import java.util.ArrayList;
import java.util.function.Function;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private VideoRepository videoRepository;

    @Test
    public void testGetRecommendedVideos() {
        String userId = "exampleUserId";
        User user = new User("1", "teste", "a@a.com", Arrays.asList(new ObjectId("65b30969b4f04b5b4cfe0b20")));
        Video video1 = new Video("12334", "Example Title", "Example Description", "https://example.com", LocalDate.now(),
                1000,
                Arrays.asList(new ObjectId("65b30969b4f04b5b4cf30b20"), new ObjectId("65b30969b4f04b5b4cf30b20")),
                new ObjectId("65b30969b4f04b5b4cf30b20"));
        when(userRepository.findById(userId)).thenReturn(Mono.just(user));
        when(videoRepository.findById("videoId1")).thenReturn(Mono.just(video1));
        when(videoRepository.findVideosByCategory(new ObjectId("65b30969b4f04b5b4cfe0ba0"))).thenReturn(Flux.just(video1));

        Flux<Video> result = userService.getRecommendedVideos(userId);

    }

}
