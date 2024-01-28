package com.postech30.movies.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CategoryTest {
    @Test
    void testGettersAndSetters() {
        Category actualCategory = new Category();
        actualCategory.setDescription("The characteristics of someone or something");
        actualCategory.setId("42");
        actualCategory.setName("Name");
        String actualDescription = actualCategory.getDescription();
        String actualId = actualCategory.getId();
        assertEquals("42", actualId);
        assertEquals("Name", actualCategory.getName());
        assertEquals("The characteristics of someone or something", actualDescription);
    }
}
