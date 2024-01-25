package com.postech30.movies.controller;

import com.postech30.movies.service.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
public class StreamVideoController {

    @Autowired
      private StreamService service;

    @GetMapping(value = "stream/{id}", produces = "video/mp4")
    public Mono<Resource> streamVideo(@PathVariable("id") String id) throws IOException {

        return service.stream(id);
    }
}
