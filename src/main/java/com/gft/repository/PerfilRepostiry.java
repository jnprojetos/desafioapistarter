package com.gft.repository;

import com.gft.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilRepostiry extends JpaRepository<Perfil, Long> {

    Optional<Perfil> findByNome(String nome);
}
