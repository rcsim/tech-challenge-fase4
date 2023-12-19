package com.postech30.movies.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
     *   <li>{@link VideoDTO#getDescription()}
     *   <li>{@link VideoDTO#getId()}
     *   <li>{@link VideoDTO#getPublishDate()}
     *   <li>{@link VideoDTO#getTitle()}
     *   <li>{@link VideoDTO#getUrl()}
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
        String actualDescription = actualVideoDTO.getDescription();
        String actualId = actualVideoDTO.getId();
        LocalDate actualPublishDate = actualVideoDTO.getPublishDate();
        String actualTitle = actualVideoDTO.getTitle();
        assertEquals("42", actualId);
        assertEquals("Dr", actualTitle);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals("https://example.org/example", actualVideoDTO.getUrl());
        assertSame(publishDate, actualPublishDate);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link VideoDTO#VideoDTO(String, String, String, String, LocalDate, Long)}
     *   <li>{@link VideoDTO#setDescription(String)}
     *   <li>{@link VideoDTO#setId(String)}
     *   <li>{@link VideoDTO#setPublishDate(LocalDate)}
     *   <li>{@link VideoDTO#setTitle(String)}
     *   <li>{@link VideoDTO#setUrl(String)}
     *   <li>{@link VideoDTO#getDescription()}
     *   <li>{@link VideoDTO#getId()}
     *   <li>{@link VideoDTO#getPublishDate()}
     *   <li>{@link VideoDTO#getTitle()}
     *   <li>{@link VideoDTO#getUrl()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        VideoDTO actualVideoDTO = new VideoDTO("42", "Dr", "The characteristics of someone or something",
                "https://example.org/example", LocalDate.of(1970, 1, 1), 100L);
        actualVideoDTO.setDescription("The characteristics of someone or something");
        actualVideoDTO.setId("42");
        LocalDate publishDate = LocalDate.of(1970, 1, 1);
        actualVideoDTO.setPublishDate(publishDate);
        actualVideoDTO.setTitle("Dr");
        actualVideoDTO.setUrl("https://example.org/example");
        String actualDescription = actualVideoDTO.getDescription();
        String actualId = actualVideoDTO.getId();
        LocalDate actualPublishDate = actualVideoDTO.getPublishDate();
        String actualTitle = actualVideoDTO.getTitle();
        assertEquals("42", actualId);
        assertEquals("Dr", actualTitle);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals("https://example.org/example", actualVideoDTO.getUrl());
        assertSame(publishDate, actualPublishDate);
    }
}
