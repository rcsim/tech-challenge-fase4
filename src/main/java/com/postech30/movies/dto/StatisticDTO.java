package com.postech30.movies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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
