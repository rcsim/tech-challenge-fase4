package com.postech30.movies.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class VideoDTOTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link VideoDTO#VideoDTO()}
     *   <li>{@link VideoDTO#setDescription(String)}
     *   <li>{@link VideoDTO#setId(String)}
     *   <li>{@link VideoDTO#setPublishDate(LocalDate)}
     *   <li>{@link VideoDTO#setTitle(String)}
     *   <li>{@link VideoDTO#setUrl(String)}
     *   <li>{@link VideoDTO#setCategoryName(String)}
     *   <li>{@link VideoDTO#setCategoryDescription(String)}
     *   <li>{@link VideoDTO#getDescription()}
     *   <li>{@link VideoDTO#getId()}
     *   <li>{@link VideoDTO#getPublishDate()}
     *   <li>{@link VideoDTO#getTitle()}
     *   <li>{@link VideoDTO#getUrl()}
     *   <li>{@link VideoDTO#getViews()}
     *   <li>{@link VideoDTO#getFavoritedBy()}
     *   <li>{@link VideoDTO#getCategoryName()}
     *   <li>{@link VideoDTO#getCategoryDescription()}
     * </ul>
     */
    @Test
    void testConstructor() {
        VideoDTO actualVideoDTO = new VideoDTO();
        actualVideoDTO.setDescription("The characteristics of someone or something");
        actualVideoDTO.setId("42");
        LocalDate publishDate = LocalDate.of(1970, 1, 1);
        actualVideoDTO.setPublishDate(publishDate);
        actualVideoDTO.setTitle("Dr");
        actualVideoDTO.setUrl("https://example.org/example");
        actualVideoDTO.setViews(100);
        actualVideoDTO.setFavoritedBy(Arrays.asList("user1", "user2"));
        actualVideoDTO.setCategoryName("Action");
        actualVideoDTO.setCategoryDescription("Action movies involve instances of physical action such as fights, stunts, car chases, etc.");

        assertEquals("42", actualVideoDTO.getId());
        assertEquals("Dr", actualVideoDTO.getTitle());
        assertEquals("The characteristics of someone or something", actualVideoDTO.getDescription());
        assertEquals("https://example.org/example", actualVideoDTO.getUrl());
        assertSame(publishDate, actualVideoDTO.getPublishDate());
        assertEquals(100, actualVideoDTO.getViews());
        assertEquals(Arrays.asList("user1", "user2"), actualVideoDTO.getFavoritedBy());
        assertEquals("Action", actualVideoDTO.getCategoryName());
        assertEquals("Action movies involve instances of physical action such as fights, stunts, car chases, etc.", actualVideoDTO.getCategoryDescription());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link VideoDTO#VideoDTO()}
     *   <li>{@link VideoDTO#setDescription(String)}
     *   <li>{@link VideoDTO#setId(String)}
     *   <li>{@link VideoDTO#setPublishDate(LocalDate)}
     *   <li>{@link VideoDTO#setTitle(String)}
     *   <li>{@link VideoDTO#setUrl(String)}
     *   <li>{@link VideoDTO#setCategoryName(String)}
     *   <li>{@link VideoDTO#setCategoryDescription(String)}
     *   <li>{@link VideoDTO#getDescription()}
     *   <li>{@link VideoDTO#getId()}
     *   <li>{@link VideoDTO#getPublishDate()}
     *   <li>{@link VideoDTO#getTitle()}
     *   <li>{@link VideoDTO#getUrl()}
     *   <li>{@link VideoDTO#getViews()}
     *   <li>{@link VideoDTO#getFavoritedBy()}
     *   <li>{@link VideoDTO#getCategoryName()}
     *   <li>{@link VideoDTO#getCategoryDescription()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LocalDate publishDate = LocalDate.of(1970, 1, 1);
        VideoDTO actualVideoDTO = VideoDTO.builder()
                .id("42")
                .title("Dr")
                .description("The characteristics of someone or something")
                .url("https://example.org/example")
                .publishDate(publishDate)
                .views(100)
                .favoritedBy(Arrays.asList("user1", "user2"))
                .categoryName("Action")
                .categoryDescription("Action movies involve instances of physical action such as fights, stunts, car chases, etc.")
                .build();

        assertEquals("42", actualVideoDTO.getId());
        assertEquals("Dr", actualVideoDTO.getTitle());
        assertEquals("The characteristics of someone or something", actualVideoDTO.getDescription());
        assertEquals("https://example.org/example", actualVideoDTO.getUrl());
        assertSame(publishDate, actualVideoDTO.getPublishDate());
        assertEquals(100, actualVideoDTO.getViews());
        assertEquals(Arrays.asList("user1", "user2"), actualVideoDTO.getFavoritedBy());
        assertEquals("Action", actualVideoDTO.getCategoryName());
        assertEquals("Action movies involve instances of physical action such as fights, stunts, car chases, etc.", actualVideoDTO.getCategoryDescription());
    }
}
