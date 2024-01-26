package com.postech30.movies.service;

import org.springframework.core.io.Resource;
import reactor.core.publisher.Mono;

import java.io.IOException;

public interface StreamService {


    Mono<Resource> stream(String id) throws IOException;
}
