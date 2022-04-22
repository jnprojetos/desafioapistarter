package com.gft.controller;


import com.gft.dto.StarterDTO;
import com.gft.dto.StarterDTOInput;
import com.gft.service.StarterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/starters")
@Api(tags = "Starters")
public class StarterController {

    @Autowired
    StarterService starterService;

    @ApiOperation(value = "Cadastrar um novo starter")
    @PostMapping(produces = "application/json")
    public ResponseEntity<StarterDTO> adicionar(@RequestPart("foto") MultipartFile foto, @RequestPart("starter") StarterDTOInput starterDTOInput) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(starterService.novoStarter(starterDTOInput, foto));
    }

    @ApiOperation(value = "Alterar um starter")
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<StarterDTO> alterar(@RequestPart("foto") MultipartFile foto, @RequestPart("starter") StarterDTOInput starterDTOInput, @PathVariable Long id) throws IOException {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(starterService.alterarStarter(id, starterDTOInput, foto));
    }

    @ApiOperation(value = "Listagem de todos os starters cadastrados")
    @GetMapping(produces = "application/json")
    public Page<StarterDTO> listarTodos(@PageableDefault Pageable pageable){
        return starterService.listarTodos(pageable);
    }

    @ApiOperation(value = "Listagem de todos os starters cadastrados em ordem alfabética crescente")
    @GetMapping(value = "/asc", produces = "application/json")
    public Page<StarterDTO> listarTodosAsc(@PageableDefault(size = 5, sort = {"nome"}, direction = Sort.Direction.ASC) Pageable pageable){
        return starterService.listarTodos(pageable);
    }

    @ApiOperation(value = "Listagem de todos os starters cadastrados em ordem alfabética decrescente")
    @GetMapping(value = "/desc", produces = "application/json")
    public Page<StarterDTO> listarTodosDesc(@PageableDefault(size = 5, sort = {"nome"}, direction = Sort.Direction.DESC) Pageable pageable){
        return starterService.listarTodos(pageable);
    }

    @ApiOperation(value = "Buscar starter por nome")
    @GetMapping(value = "/nome/{nome}", produces = "application/json")
    public ResponseEntity<StarterDTO> buscarPorNome(@PathVariable String nome){
        return ResponseEntity.status(HttpStatus.OK).body(starterService.buscarPorNome(nome));
    }

    @ApiOperation(value = "Excluir um starter")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<StarterDTO> excluir(@PathVariable Long id){
        starterService.excluirStarter(id);
        return ResponseEntity.noContent().build();
    }
}
