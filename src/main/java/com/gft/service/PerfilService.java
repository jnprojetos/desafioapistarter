package com.gft.service;

import com.gft.model.Perfil;
import com.gft.repository.PerfilRepostiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepostiry perfilRepostiry;

    public Perfil buscaPorNome(String nome){
        return perfilRepostiry.findByNome(nome).orElseThrow(()-> new RuntimeException("Perfil não cadastrado"));
    }
}
