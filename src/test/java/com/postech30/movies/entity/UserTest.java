package com.postech30.movies.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void testGettersAndSetters() {
        User actualUser = new User();
        actualUser.setEmail("jane.doe@example.org");
        ArrayList<ObjectId> favorites = new ArrayList<>();
        actualUser.setFavorites(favorites);
        actualUser.setId("42");
        actualUser.setName("Name");
        String actualEmail = actualUser.getEmail();
        List<ObjectId> actualFavorites = actualUser.getFavorites();
        String actualId = actualUser.getId();
        assertEquals("42", actualId);
        assertEquals("Name", actualUser.getName());
        assertEquals("jane.doe@example.org", actualEmail);
        assertSame(favorites, actualFavorites);
    }

}
