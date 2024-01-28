package com.postech30.movies.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FavoriteVideoDTOTest {

    @Test
    void testGettersAndSetters() {
        FavoriteVideoDTO actualFavoriteVideoDTO = new FavoriteVideoDTO();
        actualFavoriteVideoDTO.setUserId("42");
        actualFavoriteVideoDTO.setVideoId("42");
        String actualUserId = actualFavoriteVideoDTO.getUserId();

        assertEquals("42", actualUserId);
        assertEquals("42", actualFavoriteVideoDTO.getVideoId());
    }

}
