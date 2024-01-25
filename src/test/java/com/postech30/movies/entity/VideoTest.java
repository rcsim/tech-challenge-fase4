package com.postech30.movies.entity;

import com.postech30.movies.dto.CategoryDTO;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class VideoTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Video#Video()}
     *   <li>{@link Video#setDescription(String)}
     *   <li>{@link Video#setId(String)}
     *   <li>{@link Video#setPublishDate(LocalDate)}
     *   <li>{@link Video#setTitle(String)}
     *   <li>{@link Video#setUrl(String)}
     *   <li>{@link Video#setViews(Integer)}
     *   <li>{@link Video#setFavoritedBy(List<String>)}
     *   <li>{@link Video#setCategoryName(String)}
     *   <li>{@link Video#setCategoryDescription(String)}
     *   <li>{@link Video#getDescription()}
     *   <li>{@link Video#getId()}
     *   <li>{@link Video#getPublishDate()}
     *   <li>{@link Video#getTitle()}
     *   <li>{@link Video#getUrl()}
     *   <li>{@link Video#getViews()}
     *   <li>{@link Video#getFavoritedBy()}
     *   <li>{@link Video#getCategoryName()}
     *   <li>{@link Video#getCategoryDescription()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Video actualVideo = new Video();
        actualVideo.setDescription("The characteristics of someone or something");
        actualVideo.setId("42");
        LocalDate publishDate = LocalDate.of(1970, 1, 1);
        actualVideo.setPublishDate(publishDate);
        actualVideo.setTitle("Dr");
        actualVideo.setUrl("https://example.org/example");
        actualVideo.setViews(100);
        actualVideo.setCategoryName("Category Name");
        actualVideo.setCategoryDescription("Category Description");
        List<String> favoritedBy = Arrays.asList("User1", "User2");
        List<ObjectId> favoritedByObjectIds = favoritedBy.stream()
                .map(userId -> new ObjectId())
                .collect(Collectors.toList());
        actualVideo.setFavoritedBy(favoritedByObjectIds);

        String actualDescription = actualVideo.getDescription();
        String actualId = actualVideo.getId();
        LocalDate actualPublishDate = actualVideo.getPublishDate();
        String actualTitle = actualVideo.getTitle();
        Integer actualViews = actualVideo.getViews();
        String actualCategoryName = actualVideo.getCategoryName();
        String actualCategoryDescription = actualVideo.getCategoryDescription();
        List<ObjectId> actualFavoritedBy = actualVideo.getFavoritedBy();

        assertEquals("42", actualId);
        assertEquals("Dr", actualTitle);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals("https://example.org/example", actualVideo.getUrl());
        assertEquals(Integer.valueOf(100), actualViews);
        assertEquals("Category Name", actualCategoryName);
        assertEquals("Category Description", actualCategoryDescription);
        assertEquals(favoritedByObjectIds, actualFavoritedBy);
        assertSame(publishDate, actualPublishDate);
    }
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Video#Video()}
     *   <li>{@link Video#setDescription(String)}
     *   <li>{@link Video#setId(String)}
     *   <li>{@link Video#setPublishDate(LocalDate)}
     *   <li>{@link Video#setTitle(String)}
     *   <li>{@link Video#setUrl(String)}
     *   <li>{@link Video#setViews(Integer)}
     *   <li>{@link Video#setFavoritedBy(List<String>)}
     *   <li>{@link Video#setCategoryName(String)}
     *   <li>{@link Video#setCategoryDescription(String)}
     *   <li>{@link Video#getDescription()}
     *   <li>{@link Video#getId()}
     *   <li>{@link Video#getPublishDate()}
     *   <li>{@link Video#getTitle()}
     *   <li>{@link Video#getUrl()}
     *   <li>{@link Video#getViews()}
     *   <li>{@link Video#getFavoritedBy()}
     *   <li>{@link Video#getCategoryName()}
     *   <li>{@link Video#getCategoryDescription()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Video actualVideo = new Video();
        actualVideo.setId("42");
        actualVideo.setTitle("Dr");
        actualVideo.setDescription("The characteristics of someone or something");
        actualVideo.setUrl("https://example.org/example");
        LocalDate publishDate = LocalDate.of(1970, 1, 1);
        actualVideo.setPublishDate(publishDate);
        actualVideo.setViews(100);
        actualVideo.setCategoryName("Action");
        actualVideo.setCategoryDescription("Action movies involve instances of physical action such as fights, stunts, car chases, etc.");
        List<String> favoritedBy = Arrays.asList("User1", "User2");
        List<ObjectId> favoritedByObjectIds = favoritedBy.stream()
                .map(userId -> new ObjectId())
                .collect(Collectors.toList());
        actualVideo.setFavoritedBy(favoritedByObjectIds);

        String actualDescription = actualVideo.getDescription();
        String actualId = actualVideo.getId();
        LocalDate actualPublishDate = actualVideo.getPublishDate();
        String actualTitle = actualVideo.getTitle();
        Integer actualViews = actualVideo.getViews();
        String actualCategoryName = actualVideo.getCategoryName();
        String actualCategoryDescription = actualVideo.getCategoryDescription();
        List<ObjectId> actualFavoritedBy = actualVideo.getFavoritedBy();

        assertEquals("42", actualId);
        assertEquals("Dr", actualTitle);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals("https://example.org/example", actualVideo.getUrl());
        assertEquals(Integer.valueOf(100), actualViews);
        assertEquals("Action", actualCategoryName);
        assertEquals("Action movies involve instances of physical action such as fights, stunts, car chases, etc.", actualCategoryDescription);
        assertEquals(favoritedByObjectIds, actualFavoritedBy);
        assertSame(publishDate, actualPublishDate);
    }
}
