package com.gft.mapper;

import com.gft.dto.StarterDTO;
import com.gft.dto.StarterDTOInput;
import com.gft.model.Starter;

public class StarterMapper {

    public static Starter toStarter(StarterDTOInput starterDTOInput){
        return new Starter(null, starterDTOInput.getNome(), starterDTOInput.getCpf(),
                starterDTOInput.getQuatroLetras(), CategoriaMapper.toCategoriaInput(starterDTOInput.getCategoria()),
                starterDTOInput.getEmail(), starterDTOInput.getFoto());
    }

    public static StarterDTO starterDTO(Starter starter){
        return new StarterDTO(starter.getId(), starter.getNome(), starter.getCpf(), starter.getQuatroLetras(), starter.getCategoria().getDescricao(), starter.getImagem());
    }
}
