package com.projeto.devagro.service;

import com.projeto.devagro.entity.Funcionario;
import com.projeto.devagro.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> encontrarTodos() {
        return repository.findAll();
    }

    public Funcionario encontrarPorId(Long id) {
        Optional<Funcionario> obj = repository.findById(id);
        return obj.get();
    }
}