package com.gft.mapper;

import com.gft.dto.UsuarioDTO;
import com.gft.model.Usuario;

public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioDTO dto){
        return new Usuario(null, dto.getNome(), dto.getEmail(), dto.getSenha(), dto.getPerfil());
    }

}
