package com.gft.dto;

public class StarterDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String categoria;
    private byte[] foto;

    public StarterDTO(){};

    public StarterDTO(Long id, String nome, String cpf, String email, String categoria, byte[] foto) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.categoria = categoria;
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getCategoria() {
        return categoria;
    }

    public byte[] getFoto() {
        return foto;
    }
}
