package com.cti.cadastro_filme.infrastructure.repository;

import com.cti.cadastro_filme.infrastructure.entities.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
    Optional<Filme> findByTitulo(String titulo);

    @Transactional
    void deleteByTitulo(String titulo);
}
