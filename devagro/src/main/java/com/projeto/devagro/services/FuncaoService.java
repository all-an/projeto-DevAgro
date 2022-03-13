package com.projeto.devagro.services;

import com.projeto.devagro.entities.Funcao;
import com.projeto.devagro.repositories.FuncaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncaoService {

    @Autowired
    private FuncaoRepository repository;

    public List<Funcao> encontrarTodas() {
        return repository.findAll();
    }

    public Funcao encontrarPorId(Long id) {
        Optional<Funcao> obj = repository.findById(id);
        return obj.get();
    }
}