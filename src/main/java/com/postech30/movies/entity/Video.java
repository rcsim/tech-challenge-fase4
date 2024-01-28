package com.postech30.movies.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection  = "videos")
public class Video {

    @Id
    private String id;
    private String title;
    private String description;
    private String url;
    private LocalDate publishDate;
    private Integer views;
    private List<ObjectId> favoritedBy;
    private ObjectId category;
}
