package com.gft.controller;

import com.gft.dto.CategoriaDTO;
import com.gft.dto.CategoriaDTOInput;
import com.gft.service.CategoriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
@Api(tags = "Categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @ApiOperation(value = "Listagem de todas as categorias cadastradas")
    @GetMapping(produces = "application/json")
    public ResponseEntity<Page<CategoriaDTO>> listarCategorias(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(categoriaService.listarCategorias(pageable));
    }

    @ApiOperation(value = "Criar uma nova categoria")
    @PostMapping(produces = "application/json")
    public ResponseEntity<CategoriaDTO> adicionar(@Valid @RequestBody CategoriaDTOInput categoriaDTOInput){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaService.novaCategoria(categoriaDTOInput));
    }

    @ApiOperation(value = "Alterar uma categoria")
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CategoriaDTO> alterar(@Valid @PathVariable("id") Long id, @RequestBody CategoriaDTOInput categoriaDTOInput){
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoriaService.alterarCategoria(id, categoriaDTOInput));
    }

    @ApiOperation(value = "Excluir uma categoria")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CategoriaDTO> excluir(@PathVariable Long id){
        categoriaService.excluirCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
