package com.postech30.movies.service.Impl;


import com.postech30.movies.service.AwsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StreamServiceImplTest {

    @Mock
    private ResourceLoader resourceLoader;

    @Mock
    private AwsService awsService;

    @InjectMocks
    private StreamServiceImpl streamServiceImpl;  // Substitua 'SuaClasseDeServico' pelo nome real da sua classe.

    @Test
    void testStream() throws IOException {
        String fakeContent = "Test video content";
        Resource fakeResource = new ByteArrayResource(fakeContent.getBytes());

        Mockito.when(resourceLoader.getResource(Mockito.anyString())).thenReturn(fakeResource);

        Mono<Resource> resultMono = streamServiceImpl.stream("1");

        assertNotNull(resultMono.block());
    }

}
