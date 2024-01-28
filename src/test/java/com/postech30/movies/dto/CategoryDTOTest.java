package com.postech30.movies.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CategoryDTOTest {

    @Test
    void testGettersAndSetters() {
        CategoryDTO actualCategoryDTO = new CategoryDTO();
        actualCategoryDTO.setDescription("The characteristics of someone or something");
        actualCategoryDTO.setId("42");
        actualCategoryDTO.setName("Name");
        String actualDescription = actualCategoryDTO.getDescription();
        String actualId = actualCategoryDTO.getId();

        assertEquals("42", actualId);
        assertEquals("Name", actualCategoryDTO.getName());
        assertEquals("The characteristics of someone or something", actualDescription);
    }
}
