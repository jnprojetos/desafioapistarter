package com.gft.dto;

public class CategoriaDTO {

    private Long id;

    private String descricao;
    private String tecnologia;

    public CategoriaDTO(){};

    public CategoriaDTO(Long id, String descricao, String tecnologia) {
        this.id = id;
        this.descricao = descricao;
        this.tecnologia = tecnologia;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }
}
