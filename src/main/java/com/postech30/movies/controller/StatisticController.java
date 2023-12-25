package com.postech30.movies.controller;

import com.postech30.movies.dto.StatisticDTO;
import com.postech30.movies.service.StatisticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/statistics")
@AllArgsConstructor
public class StatisticController {

    private StatisticService statisticService;

    @Operation(summary = "Busca de Estatísticas", description = "Busca as estatísticas na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Estatísticas encontradas na base de dados do sistema."),
            @ApiResponse(responseCode = "400", description = "Request incorreto")})
    @GetMapping
    public Mono<StatisticDTO> getStatistics() {
        return statisticService.getStatistics();
    }
}
