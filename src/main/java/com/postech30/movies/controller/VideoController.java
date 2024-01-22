package com.postech30.movies.controller;

import com.postech30.movies.dto.CategoryDTO;
import com.postech30.movies.dto.VideoDTO;
import com.postech30.movies.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RestController
@RequestMapping("api/videos")
@AllArgsConstructor
@Validated
public class VideoController {

    private VideoService videoService;

    @Operation(summary = "Busca de Vídeos", description = "Busca todos os vídeos na base de dados do sistema. Retorna uma lista vazia caso não existam Vídeos cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Busca todos os Vídeos na base de dados do sistema. Retorna uma lista vazia caso não existam Vídeos cadastrados"),})
    @GetMapping
    public Mono<Page<VideoDTO>> getAllVideos(Pageable pageable){
        return videoService.getAllVideos(pageable)
                .collectList()
                .map(list -> new PageImpl<>(list, pageable, list.size()));
    }

    @Operation(summary = "Busca de vídeo por ID", description = "Busca o vídeo na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vídeo encontrado na base de dados do sistema."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @GetMapping(value = "{id}")
    public Mono<VideoDTO> getVideo(@Valid @PathVariable("id") String videoId) {
        return videoService.getVideo(videoId);
    }

    @Operation(summary = "Busca de vídeo por título", description = "Busca o vídeo na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vídeo encontrado na base de dados do sistema."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @GetMapping(value = "title/{title}")
    public Mono<VideoDTO> getVideoByTitle(@Valid @PathVariable("title") String title) {
        return videoService.getVideoByTitle(title);
    }

    @Operation(summary = "Busca de vídeo por data da publicação", description = "Busca o vídeo na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vídeos encontrados na base de dados do sistema."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @GetMapping(value = "publishDate/{publishDate}")
    public Flux<VideoDTO> getVideoByPublishDate(@Valid @PathVariable("publishDate") LocalDate publishDate) {
        return videoService.getVideoByPublishDate(publishDate);
    }

    @Operation(summary = "Busca de vídeo por categoria", description = "Busca o vídeo na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vídeos encontrados na base de dados do sistema."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @GetMapping(value = "category/{category}")
    public Flux<VideoDTO> getVideoByCategory(@Valid @PathVariable("category") String category) {
        return videoService.getVideoByCategory(category);
    }

    @Operation(summary = "Salva um vídeo", description = "Salva um vídeo na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vídeo salvo com sucesso."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<VideoDTO> saveVideo(@Valid @RequestBody VideoDTO videoDTO) {
        return videoService.saveVideo(videoDTO);
    }

    @Operation(summary = "Edita um vídeo", description = "Edita um vídeo na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vídeo editado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @PutMapping(value = "{id}")
    public Mono<VideoDTO> updateVideo(@Valid @RequestBody VideoDTO videoDTO,@Valid @PathVariable("id") String videoId) {
        return videoService.updateVideo(videoDTO, videoId);
    }

    @Operation(summary = "Deleta um vídeo", description = "Deleta um vídeo na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vídeo deletado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @DeleteMapping(value = "{id}")
    public Mono<Void> deleteVideo(@Valid @PathVariable("id") String videoId) {
        return videoService.deleteVideo(videoId);
    }
}
