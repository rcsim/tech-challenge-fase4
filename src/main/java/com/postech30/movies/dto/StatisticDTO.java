package com.postech30.movies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StatisticDTO {

    @JsonProperty
    private Long total;

    @JsonProperty
    private Long favorited;

    @JsonProperty
    private Double average;
}
