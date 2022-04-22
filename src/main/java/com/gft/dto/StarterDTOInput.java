package com.gft.dto;

public class StarterDTOInput {

    private String nome;
    private String cpf;
    private String quatroLetras;
    private String email;
    private CategoriaDTO categoria;
    private byte[] foto;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getQuatroLetras() {
        return quatroLetras;
    }

    public String getEmail() {
        return email;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setQuatroLetras(String quatroLetras) {
        this.quatroLetras = quatroLetras;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
