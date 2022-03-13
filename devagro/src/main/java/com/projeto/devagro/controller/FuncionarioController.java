package com.projeto.devagro.controller;

import com.projeto.devagro.entity.Funcionario;
import com.projeto.devagro.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ResponseEntity<List<Funcionario>> encontrarTodos() {
        List<Funcionario> list = service.encontrarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionario> encontrarPorId(@PathVariable Long id) {
        Funcionario obj = service.encontrarPorId(id);
        return ResponseEntity.ok().body(obj);
    }
}