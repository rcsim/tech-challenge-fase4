package com.postech30.movies.service.Impl;

import com.postech30.movies.dto.StatisticDTO;
import com.postech30.movies.repository.VideoRepository;
import com.postech30.movies.service.StatisticService;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private VideoRepository videoRepository;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<StatisticDTO> getStatistics() {
        return Mono.zip(
                        videoRepository.getTotalVideos(),
                        videoRepository.countAllByFavoritedByNotNull(),
                        videoRepository.getAverageViews()
                )
                .map(tuple -> {
                    StatisticDTO statisticDTO = new StatisticDTO();
                    statisticDTO.setTotal(tuple.getT1());
                    statisticDTO.setFavorited(tuple.getT2());
                    statisticDTO.setAverage(tuple.getT3());
                    return statisticDTO;
                });
    }
}
