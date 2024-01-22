package com.postech30.movies.controller;

import com.postech30.movies.dto.FavoriteVideoDTO;
import com.postech30.movies.service.FavoriteVideoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/favorite-videos")
@AllArgsConstructor
public class FavoriteVideoController {

    private FavoriteVideoService favoriteVideoService;

    @PostMapping
    public Mono<FavoriteVideoDTO> addFavoriteVideo(@RequestBody FavoriteVideoDTO favoriteVideoDTO ) {
        return favoriteVideoService.addFavoriteVideo(favoriteVideoDTO);
    }

//    @DeleteMapping("{videoId},{userId}")
//    public Mono<Void> removeFavoriteVideo(@PathVariable ("videoId") String videoId,
//                                          @PathVariable ("userId") String userId) {
//            return favoriteVideoService.removeFavoriteVideo(videoId, userId);
//    }

}
