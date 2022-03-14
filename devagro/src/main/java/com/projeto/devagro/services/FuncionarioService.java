package com.projeto.devagro.services;

import com.projeto.devagro.entities.Funcionario;
import com.projeto.devagro.repositories.EmpresaRepository;
import com.projeto.devagro.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Funcionario> encontrarTodos() {
        return repository.findAll();
    }

    public Funcionario encontrarPorId(Long id) {
        Optional<Funcionario> obj = repository.findById(id);
        return obj.get();
    }

    public Funcionario inserir(Funcionario funcionario) {
        return repository.save(funcionario);
    }
}