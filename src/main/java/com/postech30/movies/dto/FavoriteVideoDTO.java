package com.postech30.movies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoriteVideoDTO {

    @Id
    private  String id;

    @JsonProperty
    private String userId;

    @JsonProperty
    private  String videoId;
}
