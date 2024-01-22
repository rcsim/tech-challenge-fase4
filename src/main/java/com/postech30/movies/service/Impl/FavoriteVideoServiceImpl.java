package com.postech30.movies.service.Impl;

import com.postech30.movies.dto.FavoriteVideoDTO;
import com.postech30.movies.entity.FavoriteVideo;
import com.postech30.movies.mapper.FavoriteVideoMapper;
import com.postech30.movies.repository.FavoriteVideoRepository;
import com.postech30.movies.service.FavoriteVideoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class FavoriteVideoServiceImpl implements FavoriteVideoService {

    private FavoriteVideoRepository favoriteVideoRepository;

    @Override
    public Mono<FavoriteVideoDTO> addFavoriteVideo(FavoriteVideoDTO favoriteVideoDTO){
        Mono<FavoriteVideo> favoriteVideoMono = favoriteVideoRepository
                .save(FavoriteVideoMapper
                .mapToFavoriteVideo(favoriteVideoDTO));
        return favoriteVideoMono.map(FavoriteVideoMapper::mapToFavoriteVideoDTO);
    }

    //
//    @Override
//    public Mono<Void> removeFavoriteVideo(String videoId, String userId) {
//        return favoriteVideoRepository.deleteByVideoIdAndUserId(videoId, userId).then();
//    }

}
