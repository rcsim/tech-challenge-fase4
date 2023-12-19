package com.postech30.movies.service;

import com.postech30.movies.dto.StatisticDTO;
import reactor.core.publisher.Mono;

public interface StatisticService {

    Mono<StatisticDTO> getStatistics();
}
