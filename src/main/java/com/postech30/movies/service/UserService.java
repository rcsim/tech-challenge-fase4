package com.postech30.movies.service;

import com.postech30.movies.dto.UserDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<UserDTO> getAllUsers();

    Mono<UserDTO> getUser(String userId);

    Mono<UserDTO> saveUser(UserDTO userDTO);

    Mono<UserDTO> updateUser(UserDTO userDTO, String userId);

    Mono<Void> deleteUser(String userId);

}
