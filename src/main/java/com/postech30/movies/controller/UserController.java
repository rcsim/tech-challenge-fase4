package com.postech30.movies.controller;

import com.postech30.movies.dto.UserDTO;
import com.postech30.movies.entity.Video;
import com.postech30.movies.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @Operation(summary = "Busca de Usuários",
            description = "Busca todos os usuários na base de dados do sistema. Retorna uma lista vazia caso não existam Usuários cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Busca todos os Usuários na base de dados do sistema. Retorna uma lista vazia caso não existam Usuários cadastrados"),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @GetMapping
    public Flux<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Busca de Usuário por ID",
            description = "Busca o Usuário na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário encontrado na base de dados do sistema."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @GetMapping(value = "{id}")
    public Mono<UserDTO> getUser(@PathVariable("id") String userId) {
        return userService.getUser(userId);
    }

    @Operation(summary = "Busca de Usuário por nome",
            description = "Busca o Usuário na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Usuário adicionado"),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @Operation(summary = "Edita um Usuário",
            description = "Edita um Usuário na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário editado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @PutMapping("{id}")
    public Mono<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") String userId) {
        return userService.updateUser( userDTO, userId);
    }


    @Operation(summary = "Deleta um Usuário",
            description = "Deleta um Usuário na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @DeleteMapping("{id}")
    public Mono<Void> deleteUser(@PathVariable("id") String userId) {
        return userService.deleteUser(userId);
    }


    @Operation(summary = "Recomenda video a o usuario",
            description = "Recomenda video com base nos favoritos do usuario com base nos dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
            })
    @GetMapping("/recommendation/{userId}")
    public Flux<Video> getRecommendations(@PathVariable String userId) {

        return userService.getRecommendedVideos(userId);

    }

}
