package com.postech30.movies.mapper;

import com.postech30.movies.dto.CategoryDTO;
import com.postech30.movies.entity.Category;

import java.util.List;

public class CategoryMapper {

    public static CategoryDTO mapToCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

    public static Category mapToCategory(CategoryDTO categoryDTO) {
        return new Category(
                categoryDTO.getId(),
                categoryDTO.getName(),
                categoryDTO.getDescription()
        );
    }
}
