package com.postech30.movies.controller;

import com.postech30.movies.dto.StatisticDTO;
import com.postech30.movies.dto.VideoDTO;
import com.postech30.movies.service.StatisticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/statistics")
@AllArgsConstructor
public class StatisticController {

    private StatisticService statisticService;

    @Operation(summary = "Busca de Vídeos", description = "Busca todos os vídeos na base de dados do sistema. Retorna uma lista vazia caso não existam Vídeos cadastrados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Busca todos os Vídeos na base de dados do sistema. Retorna uma lista vazia caso não existam Vídeos cadastrados"),})
    @GetMapping
    public Mono<StatisticDTO> getStatistics() {
        return statisticService.getStatistics();
    }
}
