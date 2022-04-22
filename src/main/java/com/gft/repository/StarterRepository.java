package com.gft.repository;

import com.gft.model.Starter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StarterRepository extends JpaRepository<Starter, Long> {

    public Optional<Starter> findByCpf(String cpf);

    public Optional<Starter> findByNome(String nome);
}
