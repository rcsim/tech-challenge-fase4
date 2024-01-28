package com.postech30.movies.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.postech30.movies.dto.CategoryDTO;
import com.postech30.movies.entity.Category;
import com.postech30.movies.repository.CategoryRepository;
import com.postech30.movies.service.Impl.CategoryServiceImpl;

import java.util.ArrayList;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.reactivestreams.Publisher;
import org.springframework.http.server.reactive.ChannelSendOperator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class CategoryControllerTest {
    /**
     * Method under test: {@link CategoryController#getAllCategories()}
     */
    @Test
    void testGetAllCategories() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       com.postech30.movies.service.CategoryService
        //   See https://diff.blue/R027 to resolve this issue.

        CategoryRepository categoryRepository = mock(CategoryRepository.class);
        Flux<Category> fromIterableResult = Flux.fromIterable(new ArrayList<>());
        when(categoryRepository.findAll()).thenReturn(fromIterableResult);
        (new CategoryController(new CategoryServiceImpl(categoryRepository))).getAllCategories();
        verify(categoryRepository).findAll();
    }

    /**
     * Method under test: {@link CategoryController#getCategory(String)}
     */
    @Test
    void testGetCategory() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [ReactiveWebMergedContextConfiguration@90c1fbf testClass = com.postech30.movies.controller.DiffblueFakeClass24, locations = [], classes = [com.postech30.movies.controller.CategoryController, com.postech30.movies.service.CategoryService], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = ["org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTestContextBootstrapper=true"], contextCustomizers = [[ImportsContextCustomizer@795ea37b key = [org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration, org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration, org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration, org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration, org.springframework.boot.autoconfigure.web.reactive.error.ErrorWebFluxAutoConfiguration, org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration, org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration, org.springframework.boot.autoconfigure.security.oauth2.resource.reactive.ReactiveOAuth2ResourceServerAutoConfiguration, org.springframework.boot.test.autoconfigure.web.reactive.WebTestClientAutoConfiguration, org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration, org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration, org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration, org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration, org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration, org.springframework.boot.autoconfigure.security.oauth2.client.reactive.ReactiveOAuth2ClientAutoConfiguration, org.springframework.boot.autoconfigure.http.codec.CodecsAutoConfiguration, org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration]], org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@49f71aa0, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@4df2868c, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.autoconfigure.OverrideAutoConfigurationContextCustomizerFactory$DisableAutoConfigurationContextCustomizer@76f7f4fa, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.filter.TypeExcludeFiltersContextCustomizer@b1c8443c, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@85a5538b, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@25b9dce8, org.springframework.boot.test.context.SpringBootTestAnnotation@3033b6f6], contextLoader = org.springframework.boot.test.context.SpringBootContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   See https://diff.blue/R026 to resolve this issue.

        CategoryRepository categoryRepository = mock(CategoryRepository.class);
        Mono<Category> justResult = Mono.just(new Category());
        when(categoryRepository.findById(Mockito.<String>any())).thenReturn(justResult);
        (new CategoryController(new CategoryServiceImpl(categoryRepository))).getCategory("42");
        verify(categoryRepository).findById(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CategoryController#saveCategory(CategoryDTO)}
     */
    @Test
    void testSaveCategory() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [ReactiveWebMergedContextConfiguration@3eec3711 testClass = com.postech30.movies.controller.DiffblueFakeClass48, locations = [], classes = [com.postech30.movies.controller.CategoryController, com.postech30.movies.service.CategoryService], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = ["org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTestContextBootstrapper=true"], contextCustomizers = [[ImportsContextCustomizer@58ad5199 key = [org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration, org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration, org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration, org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration, org.springframework.boot.autoconfigure.web.reactive.error.ErrorWebFluxAutoConfiguration, org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration, org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration, org.springframework.boot.autoconfigure.security.oauth2.resource.reactive.ReactiveOAuth2ResourceServerAutoConfiguration, org.springframework.boot.test.autoconfigure.web.reactive.WebTestClientAutoConfiguration, org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration, org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration, org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration, org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration, org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration, org.springframework.boot.autoconfigure.security.oauth2.client.reactive.ReactiveOAuth2ClientAutoConfiguration, org.springframework.boot.autoconfigure.http.codec.CodecsAutoConfiguration, org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration]], org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@49f71aa0, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@4df2868c, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.autoconfigure.OverrideAutoConfigurationContextCustomizerFactory$DisableAutoConfigurationContextCustomizer@76f7f4fa, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.filter.TypeExcludeFiltersContextCustomizer@b1c8443c, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@85a5538b, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@25b9dce8, org.springframework.boot.test.context.SpringBootTestAnnotation@3033b6f6], contextLoader = org.springframework.boot.test.context.SpringBootContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   See https://diff.blue/R026 to resolve this issue.

        CategoryRepository categoryRepository = mock(CategoryRepository.class);
        Mono<Category> justResult = Mono.just(new Category());
        when(categoryRepository.save(Mockito.<Category>any())).thenReturn(justResult);
        CategoryController categoryController = new CategoryController(new CategoryServiceImpl(categoryRepository));
        categoryController.saveCategory(new CategoryDTO("42", "Name", "The characteristics of someone or something"));
        verify(categoryRepository).save(Mockito.<Category>any());
    }

    /**
     * Method under test:
     * {@link CategoryController#updateCategory(CategoryDTO, String)}
     */
    @Test
    void testUpdateCategory() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        CategoryRepository categoryRepository = mock(CategoryRepository.class);
        Mono<Category> justResult = Mono.just(new Category());
        when(categoryRepository.findById(Mockito.<String>any())).thenReturn(justResult);
        CategoryController categoryController = new CategoryController(new CategoryServiceImpl(categoryRepository));
        categoryController.updateCategory(new CategoryDTO("42", "Name", "The characteristics of someone or something"),
                "42");
        verify(categoryRepository).findById(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CategoryController#deleteCategory(String)}
     */
    @Test
    void testDeleteCategory() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        CategoryRepository categoryRepository = mock(CategoryRepository.class);
        Flux<?> source = Flux.fromIterable(new ArrayList<>());
        ChannelSendOperator<Object> channelSendOperator = new ChannelSendOperator<>(source, mock(Function.class));

        when(categoryRepository.deleteById(Mockito.<String>any())).thenReturn(channelSendOperator);
        Mono<Void> actualDeleteCategoryResult = (new CategoryController(new CategoryServiceImpl(categoryRepository)))
                .deleteCategory("42");
        verify(categoryRepository).deleteById(Mockito.<String>any());
        assertSame(channelSendOperator, actualDeleteCategoryResult);
    }
}
