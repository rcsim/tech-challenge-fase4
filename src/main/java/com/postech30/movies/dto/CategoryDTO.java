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
public class CategoryDTO {

    @Id
    private String id;

    @JsonProperty
    @NotNull(message = "O nome é um campo de preenchimento obrigatório")
    private String name;

    @JsonProperty
    @NotNull(message = "A descrição é um campo de preenchimento obrigatório")
    private String description;
}
