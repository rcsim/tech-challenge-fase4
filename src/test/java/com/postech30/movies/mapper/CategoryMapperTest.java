package com.postech30.movies.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.postech30.movies.dto.CategoryDTO;
import com.postech30.movies.entity.Category;
import org.junit.jupiter.api.Test;

class CategoryMapperTest {

    @Test
    void testMapToCategoryDTO() {
        Category category = new Category();
        category.setDescription("The characteristics of someone or something");
        category.setId("42");
        category.setName("Name");
        CategoryDTO actualMapToCategoryDTOResult = CategoryMapper.mapToCategoryDTO(category);
        assertEquals("42", actualMapToCategoryDTOResult.getId());
        assertEquals("Name", actualMapToCategoryDTOResult.getName());
        assertEquals("The characteristics of someone or something", actualMapToCategoryDTOResult.getDescription());
    }

    @Test
    void testMapToCategory() {
        Category actualMapToCategoryResult = CategoryMapper
                .mapToCategory(new CategoryDTO("42", "Name", "The characteristics of someone or something"));
        assertEquals("42", actualMapToCategoryResult.getId());
        assertEquals("Name", actualMapToCategoryResult.getName());
        assertEquals("The characteristics of someone or something", actualMapToCategoryResult.getDescription());
    }
}
