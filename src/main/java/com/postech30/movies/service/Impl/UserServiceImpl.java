package com.postech30.movies.service.Impl;

import com.postech30.movies.dto.UserDTO;
import com.postech30.movies.dto.VideoDTO;
import com.postech30.movies.entity.User;
import com.postech30.movies.entity.Video;
import com.postech30.movies.mapper.UserMapper;
import com.postech30.movies.mapper.VideoMapper;
import com.postech30.movies.repository.UserRepository;
import com.postech30.movies.repository.VideoRepository;
import com.postech30.movies.service.UserService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private VideoRepository videoRepository;



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

    @Override
    public Flux<Video> getRecommendedVideos(String userId) {
        return userRepository.findById(userId)
                .flatMapMany(user -> Flux.fromIterable(user.getFavorites())
                        .flatMap(videoId -> videoRepository.findById(videoId))
                        .flatMap(video ->  videoRepository.findVideosByCategory(new ObjectId(video.getCategory()))));
    }
}
