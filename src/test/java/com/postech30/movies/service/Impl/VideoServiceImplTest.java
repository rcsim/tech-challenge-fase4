package com.postech30.movies.service.Impl;

import com.amazonaws.services.s3.AmazonS3;
import com.postech30.movies.dto.FavoriteVideoDTO;
import com.postech30.movies.dto.VideoDTO;
import com.postech30.movies.entity.Category;
import com.postech30.movies.entity.User;
import com.postech30.movies.entity.Video;
import com.postech30.movies.repository.UserRepository;
import com.postech30.movies.repository.VideoRepository;
import com.postech30.movies.service.AwsService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {VideoServiceImpl.class})
@ExtendWith(SpringExtension.class)
class VideoServiceImplTest {
  @MockBean
  private VideoRepository videoRepository;

  @MockBean
  private UserRepository userRepository;

  @Autowired
  private VideoServiceImpl videoServiceImpl;

  @MockBean
  private ReactiveMongoTemplate reactiveMongoTemplate;


  /**
   * Method under test: {@link VideoServiceImpl#getVideoByPublishDate(LocalDate)}
   */
  @Test
  void testGetVideoByPublishDate() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [WebMergedContextConfiguration@2e42dd45 testClass = com.postech30.movies.service.Impl.DiffblueFakeClass1704, locations = [], classes = [com.postech30.movies.Application], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = ["org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true"], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@714bf186, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@23dee035, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.client.TestRestTemplateContextCustomizer@1577f53f, org.springframework.boot.test.web.reactive.server.WebTestClientContextCustomizer@53de9631, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@3779fbaa, org.springframework.boot.test.context.SpringBootTestAnnotation@3daab61e], resourceBasePath = "src/main/webapp", contextLoader = org.springframework.boot.test.context.SpringBootContextLoader, parent = null]
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
    //       at java.base/java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    VideoRepository videoRepository = mock(VideoRepository.class);
    Flux<Video> fromIterableResult = Flux.fromIterable(new ArrayList<>());
    when(videoRepository.findByPublishDate(Mockito.<LocalDate>any())).thenReturn(fromIterableResult);
    VideoServiceImpl videoServiceImpl = new VideoServiceImpl(videoRepository, mock(UserRepository.class), null);
    videoServiceImpl.getVideoByPublishDate(LocalDate.of(1970, 1, 1));
    verify(videoRepository).findByPublishDate(Mockito.<LocalDate>any());
  }

  /**
   * Method under test: {@link VideoServiceImpl#getVideoByPublishDate(LocalDate)}
   */
  @Test
  void testGetVideoByPublishDate2() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [WebMergedContextConfiguration@2e42dd45 testClass = com.postech30.movies.service.Impl.DiffblueFakeClass1704, locations = [], classes = [com.postech30.movies.Application], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = ["org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true"], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@714bf186, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@23dee035, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.client.TestRestTemplateContextCustomizer@1577f53f, org.springframework.boot.test.web.reactive.server.WebTestClientContextCustomizer@53de9631, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@3779fbaa, org.springframework.boot.test.context.SpringBootTestAnnotation@3daab61e], resourceBasePath = "src/main/webapp", contextLoader = org.springframework.boot.test.context.SpringBootContextLoader, parent = null]
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
    //       at java.base/java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    VideoRepository videoRepository = mock(VideoRepository.class);
    DirectProcessor<Video> createResult = DirectProcessor.create();
    when(videoRepository.findByPublishDate(Mockito.<LocalDate>any())).thenReturn(createResult);
    VideoServiceImpl videoServiceImpl = new VideoServiceImpl(videoRepository, mock(UserRepository.class), null);
    videoServiceImpl.getVideoByPublishDate(LocalDate.of(1970, 1, 1));
    verify(videoRepository).findByPublishDate(Mockito.<LocalDate>any());
  }

  /**
   * Method under test: {@link VideoServiceImpl#getVideoByPublishDate(LocalDate)}
   */
  @Test
  void testGetVideoByPublishDate3() {

    VideoRepository videoRepository = mock(VideoRepository.class);
    when(videoRepository.findByPublishDate(Mockito.<LocalDate>any())).thenThrow(new RuntimeException("foo"));
    VideoServiceImpl videoServiceImpl = new VideoServiceImpl(videoRepository, mock(UserRepository.class), null);
    assertThrows(RuntimeException.class, () -> videoServiceImpl.getVideoByPublishDate(LocalDate.of(1970, 1, 1)));
    verify(videoRepository).findByPublishDate(Mockito.<LocalDate>any());
  }


  /**
   * Method under test: {@link VideoServiceImpl#saveVideo(VideoDTO)}
   */
  @Test
  void testSaveVideo() {

    VideoRepository videoRepository = mock(VideoRepository.class);
    Mono<Video> justResult = Mono.just(new Video());
    when(videoRepository.save(Mockito.<Video>any())).thenReturn(justResult);
    VideoServiceImpl videoServiceImpl = new VideoServiceImpl(videoRepository, mock(UserRepository.class), null);
    videoServiceImpl.saveVideo(new VideoDTO());
    verify(videoRepository).save(Mockito.<Video>any());
  }

  /**
   * Method under test: {@link VideoServiceImpl#saveVideo(VideoDTO)}
   */
  @Test
  void testSaveVideo2() {

    VideoRepository videoRepository = mock(VideoRepository.class);
    Mono<Video> justResult = Mono.just(new Video());
    when(videoRepository.save(Mockito.<Video>any())).thenReturn(justResult);
    VideoServiceImpl videoServiceImpl = new VideoServiceImpl(videoRepository, mock(UserRepository.class), null);
    VideoDTO.VideoDTOBuilder descriptionResult = VideoDTO.builder()
            .category("Category")
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something");
    VideoDTO.VideoDTOBuilder idResult = descriptionResult.favoritedBy(new ArrayList<>()).id("42");
    VideoDTO videoDTO = idResult.publishDate(LocalDate.of(1970, 1, 1))
            .title("Dr")
            .url("https://example.org/example")
            .views(1)
            .build();
    videoServiceImpl.saveVideo(videoDTO);
    verify(videoRepository).save(Mockito.<Video>any());
  }

  /**
   * Method under test: {@link VideoServiceImpl#saveVideo(VideoDTO)}
   */
  @Test
  void testSaveVideo3() {

    VideoRepository videoRepository = mock(VideoRepository.class);
    when(videoRepository.save(Mockito.<Video>any())).thenThrow(new RuntimeException("foo"));
    VideoServiceImpl videoServiceImpl = new VideoServiceImpl(videoRepository, mock(UserRepository.class), null);
    assertThrows(RuntimeException.class, () -> videoServiceImpl.saveVideo(new VideoDTO()));
    verify(videoRepository).save(Mockito.<Video>any());
  }

  /**
   * Method under test: {@link VideoServiceImpl#favoriteVideo(FavoriteVideoDTO)}
   */
  @Test
  void testFavoriteVideo() {

    VideoRepository videoRepository = mock(VideoRepository.class);
    Mono<Video> justResult = Mono.just(new Video());
    when(videoRepository.findById(Mockito.<String>any())).thenReturn(justResult);
    UserRepository userRepository = mock(UserRepository.class);
    Mono<User> justResult2 = Mono.just(new User());
    when(userRepository.findById(Mockito.<String>any())).thenReturn(justResult2);
    VideoServiceImpl videoServiceImpl = new VideoServiceImpl(videoRepository, userRepository, null);
    videoServiceImpl.favoriteVideo(new FavoriteVideoDTO("42", "42"));
    verify(userRepository).findById(Mockito.<String>any());
    verify(videoRepository).findById(Mockito.<String>any());
  }

  /**
   * Method under test: {@link VideoServiceImpl#favoriteVideo(FavoriteVideoDTO)}
   */
  @Test
  void testFavoriteVideo2() {

    VideoRepository videoRepository = mock(VideoRepository.class);
    when(videoRepository.findById(Mockito.<String>any())).thenThrow(new RuntimeException("Usuário não encontrado "));
    UserRepository userRepository = mock(UserRepository.class);
    Mono<User> justResult = Mono.just(new User());
    when(userRepository.findById(Mockito.<String>any())).thenReturn(justResult);
    VideoServiceImpl videoServiceImpl = new VideoServiceImpl(videoRepository, userRepository, null);
    assertThrows(RuntimeException.class, () -> videoServiceImpl.favoriteVideo(new FavoriteVideoDTO("42", "42")));
    verify(userRepository).findById(Mockito.<String>any());
    verify(videoRepository).findById(Mockito.<String>any());
  }

  /**
   * Method under test: {@link VideoServiceImpl#unfavoriteVideo(FavoriteVideoDTO)}
   */
  @Test
  void testUnfavoriteVideo() {

    VideoRepository videoRepository = mock(VideoRepository.class);
    Mono<Video> justResult = Mono.just(new Video());
    when(videoRepository.findById(Mockito.<String>any())).thenReturn(justResult);
    UserRepository userRepository = mock(UserRepository.class);
    Mono<User> justResult2 = Mono.just(new User());
    when(userRepository.findById(Mockito.<String>any())).thenReturn(justResult2);
    VideoServiceImpl videoServiceImpl = new VideoServiceImpl(videoRepository, userRepository, null);
    videoServiceImpl.unfavoriteVideo(new FavoriteVideoDTO("42", "42"));
    verify(userRepository).findById(Mockito.<String>any());
    verify(videoRepository).findById(Mockito.<String>any());
  }

  /**
   * Method under test: {@link VideoServiceImpl#unfavoriteVideo(FavoriteVideoDTO)}
   */
  @Test
  void testUnfavoriteVideo2() {

    VideoRepository videoRepository = mock(VideoRepository.class);
    when(videoRepository.findById(Mockito.<String>any())).thenThrow(new RuntimeException("Usuário não encontrado "));
    UserRepository userRepository = mock(UserRepository.class);
    Mono<User> justResult = Mono.just(new User());
    when(userRepository.findById(Mockito.<String>any())).thenReturn(justResult);
    VideoServiceImpl videoServiceImpl = new VideoServiceImpl(videoRepository, userRepository, null);
    assertThrows(RuntimeException.class, () -> videoServiceImpl.unfavoriteVideo(new FavoriteVideoDTO("42", "42")));
    verify(userRepository).findById(Mockito.<String>any());
    verify(videoRepository).findById(Mockito.<String>any());
  }

}
