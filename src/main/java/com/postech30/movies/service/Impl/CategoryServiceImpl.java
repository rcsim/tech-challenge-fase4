package com.postech30.movies.service.Impl;


import com.postech30.movies.dto.CategoryDTO;
import com.postech30.movies.entity.Category;
import com.postech30.movies.entity.Video;
import com.postech30.movies.mapper.CategoryMapper;
import com.postech30.movies.repository.CategoryRepository;
import com.postech30.movies.service.CategoryService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public Flux<CategoryDTO> getAllCategories() {
        Flux<Category> categoryFlux =  categoryRepository.findAll();
        return categoryFlux.map(CategoryMapper::mapToCategoryDTO).switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<CategoryDTO> getCategory(String categoryId) {
        Mono<Category> categoryMono = categoryRepository.findById(categoryId);
        return categoryMono.map(CategoryMapper::mapToCategoryDTO);
    }

    @Override
    public Mono<CategoryDTO> saveCategory(CategoryDTO categoryDTO) {
        Mono<Category> categoryMono = categoryRepository.save(CategoryMapper.mapToCategory(categoryDTO));
        return categoryMono.map(CategoryMapper::mapToCategoryDTO);
    }

    @Override
    public Mono<CategoryDTO> updateCategory(CategoryDTO categoryDTO, String categoryId) {
        Mono<Category> categoryMono = categoryRepository.findById(categoryId);
        return categoryMono.flatMap(existingCategory -> {
            existingCategory.setName(categoryDTO.getName());
            existingCategory.setDescription(categoryDTO.getDescription());
            return categoryRepository.save(existingCategory);
        }).map(CategoryMapper::mapToCategoryDTO);
    }



    @Override
    public Mono<Void> deleteCategory(String categoryId) {
        return categoryRepository.deleteById(categoryId);
    }
}
