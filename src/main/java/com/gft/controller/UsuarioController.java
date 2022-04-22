package com.gft.controller;

import com.gft.dto.UsuarioDTO;
import com.gft.mapper.UsuarioMapper;
import com.gft.model.Usuario;
import com.gft.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
@Api(tags = "Usuários")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ApiOperation(value = "Cria um novo usuário")
    @PostMapping(produces = "application/json")
    public Usuario novoUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
        return usuarioService.novoUsuario(UsuarioMapper.toUsuario(usuarioDTO));
    }

}
