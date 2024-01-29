package com.postech30.movies.controller;

import com.postech30.movies.dto.UserDTO;
import com.postech30.movies.entity.User;
import com.postech30.movies.entity.Video;
import com.postech30.movies.repository.UserRepository;
import com.postech30.movies.repository.VideoRepository;
import com.postech30.movies.service.Impl.UserServiceImpl;
import com.postech30.movies.service.UserService;

import java.util.ArrayList;
import java.util.function.Function;

import org.bson.types.ObjectId;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.reactivestreams.Publisher;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    /**
     * Method under test: {@link UserController#getAllUsers()}
     */
    @Test
    void testGetAllUsers() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       com.postech30.movies.service.UserService
        //   See https://diff.blue/R027 to resolve this issue.

        UserRepository userRepository = mock(UserRepository.class);
        Flux<User> fromIterableResult = Flux.fromIterable(new ArrayList<>());
        when(userRepository.findAll()).thenReturn(fromIterableResult);
        (new UserController(new UserServiceImpl(userRepository, mock(VideoRepository.class)))).getAllUsers();
        verify(userRepository).findAll();
    }

    /**
     * Method under test: {@link UserController#getUser(String)}
     */
    @Test
    void testGetUser() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [ReactiveWebMergedContextConfiguration@278c6f32 testClass = com.postech30.movies.controller.DiffblueFakeClass48, locations = [], classes = [com.postech30.movies.controller.UserController, com.postech30.movies.service.UserService], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = ["org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTestContextBootstrapper=true"], contextCustomizers = [[ImportsContextCustomizer@258057bf key = [org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration, org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration, org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration, org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration, org.springframework.boot.autoconfigure.web.reactive.error.ErrorWebFluxAutoConfiguration, org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration, org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration, org.springframework.boot.autoconfigure.security.oauth2.resource.reactive.ReactiveOAuth2ResourceServerAutoConfiguration, org.springframework.boot.test.autoconfigure.web.reactive.WebTestClientAutoConfiguration, org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration, org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration, org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration, org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration, org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration, org.springframework.boot.autoconfigure.security.oauth2.client.reactive.ReactiveOAuth2ClientAutoConfiguration, org.springframework.boot.autoconfigure.http.codec.CodecsAutoConfiguration, org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration]], org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@6179f3bd, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@7e6ff5e, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.autoconfigure.OverrideAutoConfigurationContextCustomizerFactory$DisableAutoConfigurationContextCustomizer@1e2fe32, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.filter.TypeExcludeFiltersContextCustomizer@d97f6372, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@d479527d, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@361aff63, org.springframework.boot.test.context.SpringBootTestAnnotation@2edeed31], contextLoader = org.springframework.boot.test.context.SpringBootContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   See https://diff.blue/R026 to resolve this issue.

        UserRepository userRepository = mock(UserRepository.class);
        Mono<User> justResult = Mono.just(new User());
        when(userRepository.findById(Mockito.<String>any())).thenReturn(justResult);
        (new UserController(new UserServiceImpl(userRepository, mock(VideoRepository.class)))).getUser("42");
        verify(userRepository).findById(Mockito.<String>any());
    }

    /**
     * Method under test: {@link UserController#saveUser(UserDTO)}
     */
    @Test
    void testSaveUser() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [ReactiveWebMergedContextConfiguration@3a4defef testClass = com.postech30.movies.controller.DiffblueFakeClass72, locations = [], classes = [com.postech30.movies.controller.UserController, com.postech30.movies.service.UserService], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = ["org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTestContextBootstrapper=true"], contextCustomizers = [[ImportsContextCustomizer@5fb38d41 key = [org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration, org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration, org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration, org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration, org.springframework.boot.autoconfigure.web.reactive.error.ErrorWebFluxAutoConfiguration, org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration, org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration, org.springframework.boot.autoconfigure.security.oauth2.resource.reactive.ReactiveOAuth2ResourceServerAutoConfiguration, org.springframework.boot.test.autoconfigure.web.reactive.WebTestClientAutoConfiguration, org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration, org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration, org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration, org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration, org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration, org.springframework.boot.autoconfigure.security.oauth2.client.reactive.ReactiveOAuth2ClientAutoConfiguration, org.springframework.boot.autoconfigure.http.codec.CodecsAutoConfiguration, org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration]], org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@6179f3bd, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@7e6ff5e, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.autoconfigure.OverrideAutoConfigurationContextCustomizerFactory$DisableAutoConfigurationContextCustomizer@1e2fe32, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.filter.TypeExcludeFiltersContextCustomizer@d97f6372, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@d479527d, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@361aff63, org.springframework.boot.test.context.SpringBootTestAnnotation@2edeed31], contextLoader = org.springframework.boot.test.context.SpringBootContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   See https://diff.blue/R026 to resolve this issue.

        UserRepository userRepository = mock(UserRepository.class);
        Mono<User> justResult = Mono.just(new User());
        when(userRepository.save(Mockito.<User>any())).thenReturn(justResult);
        UserController userController = new UserController(
                new UserServiceImpl(userRepository, mock(VideoRepository.class)));
        userController.saveUser(new UserDTO());
        verify(userRepository).save(Mockito.<User>any());
    }

    /**
     * Method under test: {@link UserController#updateUser(UserDTO, String)}
     */
    @Test
    void testUpdateUser() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        UserRepository userRepository = mock(UserRepository.class);
        Mono<User> justResult = Mono.just(new User());
        when(userRepository.findById(Mockito.<String>any())).thenReturn(justResult);
        UserController userController = new UserController(
                new UserServiceImpl(userRepository, mock(VideoRepository.class)));
        userController.updateUser(new UserDTO(), "42");
        verify(userRepository).findById(Mockito.<String>any());
    }

    /**
     * Method under test: {@link UserController#deleteUser(String)}
     */
    @Test
    void testDeleteUser() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        UserRepository userRepository = mock(UserRepository.class);
        Flux<?> source = Flux.fromIterable(new ArrayList<>());
        ChannelSendOperator<Object> channelSendOperator = new ChannelSendOperator<>(source, mock(Function.class));

        when(userRepository.deleteById(Mockito.<String>any())).thenReturn(channelSendOperator);
        Mono<Void> actualDeleteUserResult = (new UserController(
                new UserServiceImpl(userRepository, mock(VideoRepository.class)))).deleteUser("42");
        verify(userRepository).deleteById(Mockito.<String>any());
        assertSame(channelSendOperator, actualDeleteUserResult);
    }

    @Test
    public void testGetRecommendations() {
        // Configurar dados de exemplo
        String userId = "exampleUserId";
        Video video1 = new Video("12334", "Example Title", "Example Description", "https://example.com", LocalDate.now(),
                1000,     Arrays.asList(new ObjectId("65b30969b4f04b5b4cf30b20"), new ObjectId("65b30969b4f04b5b4cf30b20")),
                new ObjectId("65b30969b4f04b5b4cf30b20"));

        when(userService.getRecommendedVideos(userId)).thenReturn(Flux.just(video1));

        userController.getRecommendations("user1");
    }

    /**
     * Method under test: {@link UserController#getRecommendations(String)}
     */
    @Test
    void testGetRecommendations2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [ReactiveWebMergedContextConfiguration@62d1f85b testClass = com.postech30.movies.controller.DiffblueFakeClass24, locations = [], classes = [com.postech30.movies.controller.UserController, com.postech30.movies.service.UserService], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = ["org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTestContextBootstrapper=true"], contextCustomizers = [[ImportsContextCustomizer@6e94554c key = [org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration, org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration, org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration, org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration, org.springframework.boot.autoconfigure.web.reactive.error.ErrorWebFluxAutoConfiguration, org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration, org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration, org.springframework.boot.autoconfigure.security.oauth2.resource.reactive.ReactiveOAuth2ResourceServerAutoConfiguration, org.springframework.boot.test.autoconfigure.web.reactive.WebTestClientAutoConfiguration, org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration, org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration, org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration, org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration, org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration, org.springframework.boot.autoconfigure.security.oauth2.client.reactive.ReactiveOAuth2ClientAutoConfiguration, org.springframework.boot.autoconfigure.http.codec.CodecsAutoConfiguration, org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration]], org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@6179f3bd, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@7e6ff5e, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.autoconfigure.OverrideAutoConfigurationContextCustomizerFactory$DisableAutoConfigurationContextCustomizer@1e2fe32, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.filter.TypeExcludeFiltersContextCustomizer@d97f6372, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@d479527d, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@361aff63, org.springframework.boot.test.context.SpringBootTestAnnotation@2edeed31], contextLoader = org.springframework.boot.test.context.SpringBootContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   See https://diff.blue/R026 to resolve this issue.

        UserRepository userRepository = mock(UserRepository.class);
        Mono<User> justResult = Mono.just(new User());
        when(userRepository.findById(Mockito.<String>any())).thenReturn(justResult);
        (new UserController(new UserServiceImpl(userRepository, mock(VideoRepository.class)))).getRecommendations("42");
        verify(userRepository).findById(Mockito.<String>any());
    }
}
