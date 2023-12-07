package com.postech30.movies.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
     *   <li>{@link Video#getDescription()}
     *   <li>{@link Video#getId()}
     *   <li>{@link Video#getPublishDate()}
     *   <li>{@link Video#getTitle()}
     *   <li>{@link Video#getUrl()}
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
        String actualDescription = actualVideo.getDescription();
        String actualId = actualVideo.getId();
        LocalDate actualPublishDate = actualVideo.getPublishDate();
        String actualTitle = actualVideo.getTitle();
        assertEquals("42", actualId);
        assertEquals("Dr", actualTitle);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals("https://example.org/example", actualVideo.getUrl());
        assertSame(publishDate, actualPublishDate);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Video#Video(String, String, String, String, LocalDate)}
     *   <li>{@link Video#setDescription(String)}
     *   <li>{@link Video#setId(String)}
     *   <li>{@link Video#setPublishDate(LocalDate)}
     *   <li>{@link Video#setTitle(String)}
     *   <li>{@link Video#setUrl(String)}
     *   <li>{@link Video#getDescription()}
     *   <li>{@link Video#getId()}
     *   <li>{@link Video#getPublishDate()}
     *   <li>{@link Video#getTitle()}
     *   <li>{@link Video#getUrl()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Video actualVideo = new Video("42", "Dr", "The characteristics of someone or something",
                "https://example.org/example", LocalDate.of(1970, 1, 1));
        actualVideo.setDescription("The characteristics of someone or something");
        actualVideo.setId("42");
        LocalDate publishDate = LocalDate.of(1970, 1, 1);
        actualVideo.setPublishDate(publishDate);
        actualVideo.setTitle("Dr");
        actualVideo.setUrl("https://example.org/example");
        String actualDescription = actualVideo.getDescription();
        String actualId = actualVideo.getId();
        LocalDate actualPublishDate = actualVideo.getPublishDate();
        String actualTitle = actualVideo.getTitle();
        assertEquals("42", actualId);
        assertEquals("Dr", actualTitle);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals("https://example.org/example", actualVideo.getUrl());
        assertSame(publishDate, actualPublishDate);
    }
}
