package com.postech30.movies.controller;

import com.postech30.movies.service.StreamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.io.IOException;

import static org.bson.assertions.Assertions.assertNotNull;


@ContextConfiguration(classes = {StreamVideoController.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StreamVideoControllerTest {

    @MockBean
    private StreamService streamService;

    @Autowired
    private StreamVideoController streamVideoController;


    @Test
    void testStreamVideo() throws IOException {
        String fakeVideoId = "fakeId";
        String fakeContent = "Test video content";
        Resource fakeResource = new ByteArrayResource(fakeContent.getBytes());
        Mockito.when(streamService.stream(fakeVideoId)).thenReturn(Mono.just(fakeResource));

        WebTestClient webTestClient = WebTestClient.bindToController(streamVideoController).build();

        webTestClient.get()
                .uri("/stream/{id}", fakeVideoId)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Resource.class)
                .value(resource -> {
                    assertNotNull(resource);
                });
    }
}
