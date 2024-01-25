package com.postech30.movies.mapper;

import com.postech30.movies.dto.UserDTO;
import com.postech30.movies.entity.User;
import org.bson.types.ObjectId;

import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO mapToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .favorites(user.getFavorites() != null ? user.getFavorites().stream()
                        .map(ObjectId::toHexString)
                        .collect(Collectors.toList()) : null)
                .build();
    }

    public static User mapToUser(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getFavorites() != null ?
                        userDTO.getFavorites().stream()
                                .map(ObjectId::new)
                                .collect(Collectors.toList()) : null
        );
    }
}

