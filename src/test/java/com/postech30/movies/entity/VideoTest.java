package com.postech30.movies.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

class VideoTest {
    @Test
    void testGettersAndSetters() {
        Video actualVideo = new Video();
        actualVideo.setCategory(new ObjectId("65b56b440c75f588c2abf86b"));
        actualVideo.setDescription("The characteristics of someone or something");
        ArrayList<ObjectId> favoritedBy = new ArrayList<>();
        actualVideo.setFavoritedBy(favoritedBy);
        actualVideo.setId("42");
        LocalDate publishDate = LocalDate.of(1970, 1, 1);
        actualVideo.setPublishDate(publishDate);
        actualVideo.setTitle("Dr");
        actualVideo.setUrl("https://example.org/example");
        actualVideo.setViews(1);
        ObjectId actualCategory = actualVideo.getCategory();
        String actualDescription = actualVideo.getDescription();
        List<ObjectId> actualFavoritedBy = actualVideo.getFavoritedBy();
        String actualId = actualVideo.getId();
        LocalDate actualPublishDate = actualVideo.getPublishDate();
        String actualTitle = actualVideo.getTitle();
        String actualUrl = actualVideo.getUrl();
        assertEquals("42", actualId);
        assertEquals(new ObjectId("65b56b440c75f588c2abf86b"), actualCategory);
        assertEquals("Dr", actualTitle);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals("https://example.org/example", actualUrl);
        assertEquals(1, actualVideo.getViews().intValue());
        assertSame(favoritedBy, actualFavoritedBy);
        assertSame(publishDate, actualPublishDate);
    }
}
