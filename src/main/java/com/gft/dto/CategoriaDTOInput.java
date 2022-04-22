package com.gft.dto;

import javax.validation.constraints.NotBlank;

public class CategoriaDTOInput {

    @NotBlank (message = "Descrição é obrigatoria.")
    private String descricao;

    @NotBlank(message = "Tencologia é obrigatória.")
    private String tecnologia;

    public String getDescricao() {
        return descricao;
    }

    public String getTecnologia() {
        return tecnologia;
    }
}
