package com.postech30.movies.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VideoDTO {

    @Id
    private String id;

    @JsonProperty
    @NotNull(message = "O titulo é um campo de preenchimento obrigatório")
    private String title;

    @JsonProperty
    @NotNull(message = "A descrição é um campo de preenchimento obrigatório")
    private String description;

    @JsonProperty
    @NotNull(message = "A url é um campo de preenchimento obrigatório")
    private String url;

    @JsonProperty
    @NotNull(message = "A data de publicação é um campo de preenchimento obrigatório")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate publishDate;

    @JsonProperty
    private Integer views;

    @JsonProperty
    private List<String> favoritedBy;

    @JsonProperty
    private String category;

    @JsonProperty
    private String categoryName;

    @JsonProperty
    private String categoryDescription;

}
