package com.postech30.movies.service;

import com.postech30.movies.dto.UserDTO;
import com.postech30.movies.dto.VideoDTO;
import com.postech30.movies.entity.Video;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<UserDTO> getAllUsers();

    Mono<UserDTO> getUser(String userId);

    Mono<UserDTO> saveUser(UserDTO userDTO);

    Mono<UserDTO> updateUser(UserDTO userDTO, String userId);

    Mono<Void> deleteUser(String userId);

    Flux<Video> getRecommendedVideos(String userId);

}
