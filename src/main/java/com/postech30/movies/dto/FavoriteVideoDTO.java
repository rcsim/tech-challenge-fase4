package com.postech30.movies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FavoriteVideoDTO {

    @JsonProperty
    @NotNull(message = "O name é um campo de preenchimento obrigatório")
    private String userId;

    @JsonProperty
    @NotNull(message = "O name é um campo de preenchimento obrigatório")
    private  String videoId;
}
