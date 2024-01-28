package com.postech30.movies.service.Impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.postech30.movies.dto.CategoryDTO;
import com.postech30.movies.entity.Category;
import com.postech30.movies.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {CategoryServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CategoryServiceImplTest {
    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    /**
     * Method under test: {@link CategoryServiceImpl#getAllCategories()}
     */
    @Test
    void testGetAllCategories() {
        Flux<Category> fromIterableResult = Flux.fromIterable(new ArrayList<>());
        when(categoryRepository.findAll()).thenReturn(fromIterableResult);
        categoryServiceImpl.getAllCategories();
        verify(categoryRepository).findAll();
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getAllCategories()}
     */
    @Test
    void testGetAllCategories2() {
        DirectProcessor<Category> createResult = DirectProcessor.create();
        when(categoryRepository.findAll()).thenReturn(createResult);
        categoryServiceImpl.getAllCategories();
        verify(categoryRepository).findAll();
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getAllCategories()}
     */
    @Test
    void testGetAllCategories3() {
        Flux<Category> flux = mock(Flux.class);
        Flux<Object> fromIterableResult = Flux.fromIterable(new ArrayList<>());
        when(flux.map(Mockito.<Function<Category, Object>>any())).thenReturn(fromIterableResult);
        when(categoryRepository.findAll()).thenReturn(flux);
        categoryServiceImpl.getAllCategories();
        verify(categoryRepository).findAll();
        verify(flux).map(Mockito.<Function<Category, Object>>any());
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getAllCategories()}
     */
    @Test
    void testGetAllCategories4() {
        Flux<Object> flux = mock(Flux.class);
        Flux<Object> fromIterableResult = Flux.fromIterable(new ArrayList<>());
        when(flux.switchIfEmpty(Mockito.<Publisher<Object>>any())).thenReturn(fromIterableResult);
        Flux<Category> flux2 = mock(Flux.class);
        when(flux2.map(Mockito.<Function<Category, Object>>any())).thenReturn(flux);
        when(categoryRepository.findAll()).thenReturn(flux2);
        Flux<CategoryDTO> actualAllCategories = categoryServiceImpl.getAllCategories();
        verify(categoryRepository).findAll();
        verify(flux2).map(Mockito.<Function<Category, Object>>any());
        verify(flux).switchIfEmpty(Mockito.<Publisher<Object>>any());
        assertSame(fromIterableResult, actualAllCategories);
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getCategory(String)}
     */
    @Test
    void testGetCategory() {
        Mono<Category> justResult = Mono.just(new Category());
        when(categoryRepository.findById(Mockito.<String>any())).thenReturn(justResult);
        categoryServiceImpl.getCategory("42");
        verify(categoryRepository).findById(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getCategory(String)}
     */
    @Test
    void testGetCategory2() {
        Mono<Category> mono = mock(Mono.class);
        Mono<Object> justResult = Mono.just("Data");
        when(mono.map(Mockito.<Function<Category, Object>>any())).thenReturn(justResult);
        when(categoryRepository.findById(Mockito.<String>any())).thenReturn(mono);
        Mono<CategoryDTO> actualCategory = categoryServiceImpl.getCategory("42");
        verify(categoryRepository).findById(Mockito.<String>any());
        verify(mono).map(Mockito.<Function<Category, Object>>any());
        assertSame(justResult, actualCategory);
    }

    /**
     * Method under test: {@link CategoryServiceImpl#saveCategory(CategoryDTO)}
     */
    @Test
    void testSaveCategory() {
        Mono<Category> justResult = Mono.just(new Category());
        when(categoryRepository.save(Mockito.<Category>any())).thenReturn(justResult);
        categoryServiceImpl.saveCategory(new CategoryDTO("42", "Name", "The characteristics of someone or something"));
        verify(categoryRepository).save(Mockito.<Category>any());
    }

    /**
     * Method under test: {@link CategoryServiceImpl#saveCategory(CategoryDTO)}
     */
    @Test
    void testSaveCategory2() {
        Mono<Category> mono = mock(Mono.class);
        Mono<Object> justResult = Mono.just("Data");
        when(mono.map(Mockito.<Function<Category, Object>>any())).thenReturn(justResult);
        when(categoryRepository.save(Mockito.<Category>any())).thenReturn(mono);
        Mono<CategoryDTO> actualSaveCategoryResult = categoryServiceImpl
                .saveCategory(new CategoryDTO("42", "Name", "The characteristics of someone or something"));
        verify(categoryRepository).save(Mockito.<Category>any());
        verify(mono).map(Mockito.<Function<Category, Object>>any());
        assertSame(justResult, actualSaveCategoryResult);
    }

    /**
     * Method under test: {@link CategoryServiceImpl#saveCategory(CategoryDTO)}
     */
    @Test
    void testSaveCategory3() {
        Mono<Category> mono = mock(Mono.class);
        Mono<Object> justResult = Mono.just("Data");
        when(mono.map(Mockito.<Function<Category, Object>>any())).thenReturn(justResult);
        when(categoryRepository.save(Mockito.<Category>any())).thenReturn(mono);
        CategoryDTO categoryDTO = mock(CategoryDTO.class);
        when(categoryDTO.getDescription()).thenReturn("The characteristics of someone or something");
        when(categoryDTO.getId()).thenReturn("42");
        when(categoryDTO.getName()).thenReturn("Name");
        Mono<CategoryDTO> actualSaveCategoryResult = categoryServiceImpl.saveCategory(categoryDTO);
        verify(categoryDTO).getDescription();
        verify(categoryDTO).getId();
        verify(categoryDTO).getName();
        verify(categoryRepository).save(Mockito.<Category>any());
        verify(mono).map(Mockito.<Function<Category, Object>>any());
        assertSame(justResult, actualSaveCategoryResult);
    }

    /**
     * Method under test:
     * {@link CategoryServiceImpl#updateCategory(CategoryDTO, String)}
     */
    @Test
    void testUpdateCategory() {
        Mono<Category> justResult = Mono.just(new Category());
        when(categoryRepository.findById(Mockito.<String>any())).thenReturn(justResult);
        categoryServiceImpl.updateCategory(new CategoryDTO("42", "Name", "The characteristics of someone or something"),
                "42");
        verify(categoryRepository).findById(Mockito.<String>any());
    }

    /**
     * Method under test:
     * {@link CategoryServiceImpl#updateCategory(CategoryDTO, String)}
     */
    @Test
    void testUpdateCategory2() {
        Mono<Category> mono = mock(Mono.class);
        Mono<Object> justResult = Mono.just("Data");
        when(mono.flatMap(Mockito.<Function<Category, Mono<Object>>>any())).thenReturn(justResult);
        when(categoryRepository.findById(Mockito.<String>any())).thenReturn(mono);
        categoryServiceImpl.updateCategory(new CategoryDTO("42", "Name", "The characteristics of someone or something"),
                "42");
        verify(categoryRepository).findById(Mockito.<String>any());
        verify(mono).flatMap(Mockito.<Function<Category, Mono<Object>>>any());
    }

    /**
     * Method under test:
     * {@link CategoryServiceImpl#updateCategory(CategoryDTO, String)}
     */
    @Test
    void testUpdateCategory3() {
        Mono<Object> mono = mock(Mono.class);
        Mono<Object> justResult = Mono.just("Data");
        when(mono.map(Mockito.<Function<Object, Object>>any())).thenReturn(justResult);
        Mono<Category> mono2 = mock(Mono.class);
        when(mono2.flatMap(Mockito.<Function<Category, Mono<Object>>>any())).thenReturn(mono);
        when(categoryRepository.findById(Mockito.<String>any())).thenReturn(mono2);
        Mono<CategoryDTO> actualUpdateCategoryResult = categoryServiceImpl
                .updateCategory(new CategoryDTO("42", "Name", "The characteristics of someone or something"), "42");
        verify(categoryRepository).findById(Mockito.<String>any());
        verify(mono2).flatMap(Mockito.<Function<Category, Mono<Object>>>any());
        verify(mono).map(Mockito.<Function<Object, Object>>any());
        assertSame(justResult, actualUpdateCategoryResult);
    }

    /**
     * Method under test: {@link CategoryServiceImpl#deleteCategory(String)}
     */
    @Test
    void testDeleteCategory() {
        Flux<?> source = Flux.fromIterable(new ArrayList<>());
        ChannelSendOperator<Object> channelSendOperator = new ChannelSendOperator<>(source, mock(Function.class));

        when(categoryRepository.deleteById(Mockito.<String>any())).thenReturn(channelSendOperator);
        Mono<Void> actualDeleteCategoryResult = categoryServiceImpl.deleteCategory("42");
        verify(categoryRepository).deleteById(Mockito.<String>any());
        assertSame(channelSendOperator, actualDeleteCategoryResult);
    }
}
