package com.postech30.movies.service.Impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.postech30.movies.repository.VideoRepository;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

class StatisticServiceImplTest {
    /**
     * Method under test: {@link StatisticServiceImpl#getStatistics()}
     */
    @Test
    void testGetStatistics() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        VideoRepository videoRepository = mock(VideoRepository.class);
        Mono<Long> justResult = Mono.<Long>just(1L);
        when(videoRepository.countAllByFavoritedByNotNull()).thenReturn(justResult);
        Mono<Double> justResult2 = Mono.<Double>just(10.0d);
        when(videoRepository.getAverageViews()).thenReturn(justResult2);
        Mono<Long> justResult3 = Mono.<Long>just(1L);
        when(videoRepository.getTotalVideos()).thenReturn(justResult3);
        (new StatisticServiceImpl(videoRepository, null)).getStatistics();
        verify(videoRepository).countAllByFavoritedByNotNull();
        verify(videoRepository).getAverageViews();
        verify(videoRepository).getTotalVideos();
    }
}
