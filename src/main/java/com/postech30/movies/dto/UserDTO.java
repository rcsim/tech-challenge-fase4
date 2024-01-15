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
public class UserDTO {
    @Id
    private String id;

    @JsonProperty
    @NotNull(message = "O name é um campo de preenchimento obrigatório")
    private String name;

    @JsonProperty
    @NotNull(message = "O email é um campo de preenchimento obrigatório")
    private String email;
}
