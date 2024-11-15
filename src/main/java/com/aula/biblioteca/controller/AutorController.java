package com.aula.biblioteca.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aula.biblioteca.dto.AutorDto;
import com.aula.biblioteca.service.AutorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/autores")
public class AutorController {

    private final AutorService autorService;

    @Operation(description = "Listar todos os autores com paginação da base de dados", summary = "Listar todos os autores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorno de autores", content = @Content(mediaType = "application/json", schema=@Schema(implementation = Page.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<AutorDto>> findAll(@Parameter(required = true) @PageableDefault(size = 5) Pageable pageable){
        return ResponseEntity.ok(autorService.findAll(pageable));
    }
    
    @Operation(description = "Inserir novo autor no banco de dados.", summary = "Inserir autor.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Autor criado", content = @Content(mediaType = "application/json", schema=@Schema(implementation = Page.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutorDto> save(@RequestBody AutorDto autorDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(autorService.save(autorDto));
    }
    @Operation(description = "Alterar instancia usuario no banco de dados.", summary = "Alterar autor.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Autor alterado", content = @Content(mediaType = "application/json", schema=@Schema(implementation = Page.class)))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutorDto> update(@PathVariable String id, @RequestBody AutorDto autorDto){
        return ResponseEntity.ok(autorService.update(id, autorDto));
    }

}
