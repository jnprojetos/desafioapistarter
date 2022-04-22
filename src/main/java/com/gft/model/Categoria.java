package com.gft.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String tecnologia;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
    private List<Starter> starters;

    public Categoria(){};

    public Categoria(Long id, String descricao, String tecnologia) {
        this.id = id;
        this.descricao = descricao;
        this.tecnologia = tecnologia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public List<Starter> getStarters() {
        return starters;
    }

    public void setStarters(List<Starter> starters) {
        this.starters = starters;
    }
}
