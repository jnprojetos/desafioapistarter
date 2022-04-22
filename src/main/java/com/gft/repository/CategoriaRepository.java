package com.gft.repository;

import com.gft.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByDescricaoAndTecnologia(String descricao, String tecnologia);

    @Query("SELECT CASE WHEN SIZE(c.starters) > 0 THEN true ELSE false END "
            + " FROM Categoria c WHERE c.id = ?1")
    Boolean possuiStarters(Long categoriaId);
}
