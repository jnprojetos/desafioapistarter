package com.gft.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Starter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatorio")
    private String nome;

    @NotBlank
    @CPF(message = "CPF inválido")
    private String cpf;

    @NotBlank(message = "Quatro letras é obrigatorio")
    @Size(min = 4, max = 4)
    private String quatroLetras;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    @Email
    private String email;

    @Lob
    @Column(columnDefinition = "BLOB")
    public byte[] imagem;

    public Starter(){};

    public Starter(Long id, String nome, String cpf, String quatroLetras, Categoria categoria, String email, byte[] imagem) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.quatroLetras = quatroLetras;
        this.categoria = categoria;
        this.email = email;
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getQuatroLetras() {
        return quatroLetras;
    }

    public void setQuatroLetras(String quatroLetras) {
        this.quatroLetras = quatroLetras;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
