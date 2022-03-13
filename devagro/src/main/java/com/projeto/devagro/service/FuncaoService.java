package com.projeto.devagro.service;

import com.projeto.devagro.entity.Funcao;
import com.projeto.devagro.repository.FuncaoRepository;
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