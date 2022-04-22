package com.gft.dto;

import com.gft.model.Perfil;

public class UsuarioDTO {

    private String nome;
    private String email;
    private String senha;
    private Perfil perfil;

    public UsuarioDTO(String nome, String email, String senha, Perfil perfil) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
