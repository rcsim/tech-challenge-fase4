package com.postech30.movies.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.postech30.movies.dto.StatisticDTO;
import com.postech30.movies.service.StatisticService;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

class StatisticControllerTest {
    /**
     * Method under test: {@link StatisticController#getStatistics()}
     */
    @Test
    void testGetStatistics() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       com.postech30.movies.service.StatisticService
        //   See https://diff.blue/R027 to resolve this issue.

        StatisticService statisticService = mock(StatisticService.class);
        StatisticDTO buildResult = StatisticDTO.builder().average(10.0d).favorited(1L).total(1L).build();
        Mono<StatisticDTO> justResult = Mono.just(buildResult);
        when(statisticService.getStatistics()).thenReturn(justResult);
        Mono<StatisticDTO> actualStatistics = (new StatisticController(statisticService)).getStatistics();
        verify(statisticService).getStatistics();
        assertSame(justResult, actualStatistics);
    }
}
