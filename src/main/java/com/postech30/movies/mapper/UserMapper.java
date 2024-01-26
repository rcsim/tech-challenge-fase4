package com.postech30.movies.mapper;

import com.postech30.movies.dto.UserDTO;
import com.postech30.movies.entity.User;

public class UserMapper {

    public static UserDTO mapToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static User mapToUser(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail(),
                null
        );
    }
}
