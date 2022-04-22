package com.gft.mapper;

import com.gft.dto.CategoriaDTO;
import com.gft.dto.CategoriaDTOInput;
import com.gft.model.Categoria;

public class CategoriaMapper {

    public static Categoria toCategoria(CategoriaDTOInput categoria){
        return new Categoria(null, categoria.getDescricao(), categoria.getTecnologia());
    }

    public static CategoriaDTO toCategoriaDTO(Categoria categoria){
        return new CategoriaDTO(categoria.getId(), categoria.getDescricao(), categoria.getTecnologia());
    }

    public static Categoria toCategoriaInput(CategoriaDTO categoriaDTO){
        return new Categoria(categoriaDTO.getId(), categoriaDTO.getDescricao(), categoriaDTO.getTecnologia());
    }
}
