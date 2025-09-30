package com.cti.cadastro_filme.business;

import com.cti.cadastro_filme.infrastructure.entities.Filme;
import com.cti.cadastro_filme.infrastructure.repository.FilmeRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public void salvarFilme(Filme filme){
        repository.saveAndFlush(filme);
    }

    public Filme buscarFilmePorTitulo(String titulo){
        return repository.findByTitulo(titulo).orElseThrow(
                () -> new RuntimeException("Título não encontrado")
        );
    }

    public void deletarFilmePorTitulo(String titulo){
        repository.deleteByTitulo(titulo);
    }

    public void atualizarFilmePorId(Integer id, Filme filme){
        Filme filmeEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Filme não encontrado"));
        Filme filmeAtualizado = Filme.builder()
                .titulo(filme.getTitulo() != null ? filme.getTitulo() :
                        filmeEntity.getTitulo())
                .diretor(filme.getDiretor() != null ? filme.getDiretor() :
                        filmeEntity.getTitulo())
                .id(filmeEntity.getId())
                .build();

        repository.saveAndFlush(filmeAtualizado);
    }
}
