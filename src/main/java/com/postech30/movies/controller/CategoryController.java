package com.postech30.movies.controller;

import com.postech30.movies.dto.CategoryDTO;
import com.postech30.movies.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @Operation(summary = "Busca de Categorias", description = "Busca todas as categorias na base de dados do sistema. Retorna uma lista vazia caso não existam Categorias cadastradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Busca todas as Categorias na base de dados do sistema. Retorna uma lista vazia caso não existam Categorias cadastradas"),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @GetMapping
    public Flux<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }


    @Operation(summary = "Busca de Categoria por ID", description = "Busca a Categoria na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Categoria encontrada na base de dados do sistema."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @GetMapping(value = "{id}")
    public Mono<CategoryDTO> getCategory(@PathVariable("id") String categoryId) {
        return categoryService.getCategory(categoryId);
    }

    @Operation(summary = "Salva uma Categoria", description = "Salva uma Categoria na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Categoria salva com sucesso."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CategoryDTO> saveCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.saveCategory(categoryDTO);
    }

    @Operation(summary = "Edita uma Categoria", description = "Edita uma Categoria na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Categoria editada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @PutMapping("{id}")
    public Mono<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable("id") String categoryId) {
        return categoryService.updateCategory(categoryDTO, categoryId);
    }

    @Operation(summary = "Deleta uma Categoria", description = "Deleta uma Categoria na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Categoria deletada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @DeleteMapping("{id}")
    public Mono<Void> deleteCategory(@PathVariable("id") String categoryId) {
        return categoryService.deleteCategory(categoryId);
    }
}
