package com.postech30.movies.service;

import com.postech30.movies.dto.CategoryDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryService {

    Flux<CategoryDTO> getAllCategories();

    Mono<CategoryDTO> getCategory(String categoryId);

    Mono<CategoryDTO> saveCategory(CategoryDTO categoryDTO);

    Mono<CategoryDTO> updateCategory(CategoryDTO categoryDTO, String categoryId);

    Mono<Void> deleteCategory(String categoryId);
}
