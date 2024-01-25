package com.postech30.movies.service.Impl;

import com.postech30.movies.service.AwsService;
import com.postech30.movies.service.StreamService;
import com.postech30.movies.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
public class StreamServiceImpl implements StreamService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private AwsService awsService;

    @Override
    public Mono<Resource> stream(String id) throws IOException {
        awsService.getVideoById(id);

        return Mono.fromSupplier(() -> resourceLoader.getResource("file:"+ PathUtil.getVideoPath()));
    }
}
