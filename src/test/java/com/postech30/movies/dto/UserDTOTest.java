package com.postech30.movies.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UserDTOTest {
    @Test
    void testGettersAndSetters() {
        UserDTO actualUserDTO = new UserDTO();
        actualUserDTO.setEmail("jane.doe@example.org");
        ArrayList<String> favorites = new ArrayList<>();
        actualUserDTO.setFavorites(favorites);
        actualUserDTO.setId("42");
        actualUserDTO.setName("Name");
        String actualEmail = actualUserDTO.getEmail();
        List<String> actualFavorites = actualUserDTO.getFavorites();
        String actualId = actualUserDTO.getId();
        assertEquals("42", actualId);
        assertEquals("Name", actualUserDTO.getName());
        assertEquals("jane.doe@example.org", actualEmail);
        assertSame(favorites, actualFavorites);
    }

}
