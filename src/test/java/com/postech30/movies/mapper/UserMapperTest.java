package com.postech30.movies.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.postech30.movies.dto.UserDTO;
import com.postech30.movies.entity.User;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

class UserMapperTest {

    @Test
    void testMapToUserDTO() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        ArrayList<ObjectId> favorites = new ArrayList<>();
        user.setFavorites(favorites);
        user.setId("42");
        user.setName("Name");
        UserDTO actualMapToUserDTOResult = UserMapper.mapToUserDTO(user);
        assertEquals("42", actualMapToUserDTOResult.getId());
        assertEquals("Name", actualMapToUserDTOResult.getName());
        assertEquals("jane.doe@example.org", actualMapToUserDTOResult.getEmail());
        assertEquals(favorites, actualMapToUserDTOResult.getFavorites());
    }

    @Test
    void testMapToUser() {
        User actualMapToUserResult = UserMapper.mapToUser(new UserDTO());
        assertNull(actualMapToUserResult.getEmail());
        assertNull(actualMapToUserResult.getId());
        assertNull(actualMapToUserResult.getName());
        assertNull(actualMapToUserResult.getFavorites());
    }

    @Test
    void testMapToUser2() {
        UserDTO.UserDTOBuilder emailResult = UserDTO.builder().email("jane.doe@example.org");
        ArrayList<String> favorites = new ArrayList<>();
        UserDTO userDTO = emailResult.favorites(favorites).id("42").name("Name").build();
        User actualMapToUserResult = UserMapper.mapToUser(userDTO);
        assertEquals("42", actualMapToUserResult.getId());
        assertEquals("Name", actualMapToUserResult.getName());
        assertEquals("jane.doe@example.org", actualMapToUserResult.getEmail());
        assertEquals(favorites, actualMapToUserResult.getFavorites());
    }
}
