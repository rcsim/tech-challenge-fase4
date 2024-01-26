package com.postech30.movies.controller;

import com.postech30.movies.entity.Video;
import com.postech30.movies.service.UserService;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.Mockito.when;
@SpringBootTest
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void testGetRecommendations() {
        // Configurar dados de exemplo
        String userId = "exampleUserId";
        Video video1 = new Video(
                "12334",
                "Example Title",
                "Example Description",
                "https://example.com",
                LocalDate.now(),
                1000,
                Arrays.asList("user1", "user2"),
                "65b30969b4f04b5b4cfe0ba0",
                "Example Category Name",
                "Example Category Description"
        );

        when(userService.getRecommendedVideos(userId)).thenReturn(Flux.just(video1));

        userController.getRecommendations("user1");
    }
}
