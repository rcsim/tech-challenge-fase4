package com.postech30.movies.service.Impl;

import com.postech30.movies.dto.UserDTO;
import com.postech30.movies.entity.User;
import com.postech30.movies.mapper.UserMapper;
import com.postech30.movies.repository.UserRepository;
import com.postech30.movies.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public Flux<UserDTO> getAllUsers() {
        Flux<User> userFlux = userRepository.findAll();
        return userFlux.map(UserMapper::mapToUserDTO).switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<UserDTO> getUser(String userId) {
        Mono<User> userMono = userRepository.findById(userId);
        return userMono.map(UserMapper::mapToUserDTO);
    }

    @Override
    public Mono<UserDTO> saveUser(UserDTO userDTO) {
        Mono<User> userMono = userRepository.save(UserMapper.mapToUser(userDTO));
        return userMono.map(UserMapper::mapToUserDTO);
    }

    @Override
    public Mono<UserDTO> updateUser(UserDTO userDTO, String userId) {
        Mono<User> userMono = userRepository.findById(userId);
        return userMono.flatMap(existingUser -> {
            existingUser.setName(userDTO.getName());
            existingUser.setEmail(userDTO.getEmail());
            return userRepository.save(existingUser);
        }).map(UserMapper::mapToUserDTO);
    }

    @Override
    public Mono<Void> deleteUser(String userId) {
        return userRepository.deleteById(userId);
    }
}
