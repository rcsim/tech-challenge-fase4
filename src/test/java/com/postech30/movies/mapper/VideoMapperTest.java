package com.postech30.movies.mapper;

import com.postech30.movies.dto.VideoDTO;
import com.postech30.movies.entity.Video;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class VideoMapperTest {
    /**
     * Method under test: {@link VideoMapper#mapToVideoDTO(Video)}
     */
    @Test
    void testMapToVideoDTO() {
        Video video = new Video();
        video.setDescription("The characteristics of someone or something");
        video.setId("42");
        video.setPublishDate(LocalDate.of(1970, 1, 1));
        video.setTitle("Dr");
        video.setUrl("https://example.org/example");
        VideoDTO actualMapToVideoDTOResult = VideoMapper.mapToVideoDTO(video);
        assertEquals("1970-01-01", actualMapToVideoDTOResult.getPublishDate().toString());
        assertEquals("42", actualMapToVideoDTOResult.getId());
        assertEquals("Dr", actualMapToVideoDTOResult.getTitle());
        assertEquals("The characteristics of someone or something", actualMapToVideoDTOResult.getDescription());
        assertEquals("https://example.org/example", actualMapToVideoDTOResult.getUrl());
    }

    /**
     * Method under test: {@link VideoMapper#mapToVideo(VideoDTO)}
     */
    @Test
    void testMapToVideo() {
        Video actualMapToVideoResult = VideoMapper.mapToVideo(new VideoDTO());
        assertNull(actualMapToVideoResult.getDescription());
        assertNull(actualMapToVideoResult.getId());
        assertNull(actualMapToVideoResult.getTitle());
        assertNull(actualMapToVideoResult.getUrl());
        assertNull(actualMapToVideoResult.getPublishDate());
    }
}
