package com.projeto.devagro.controller;

import com.projeto.devagro.entity.Funcao;
import com.projeto.devagro.service.FuncaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/funcoes")
public class FuncaoController {

    @Autowired
    private FuncaoService service;

    @GetMapping
    public ResponseEntity<List<Funcao>> encontrarTodas() {
        List<Funcao> list = service.encontrarTodas();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcao> encontrarPorId(@PathVariable Long id) {
        Funcao obj = service.encontrarPorId(id);
        return ResponseEntity.ok().body(obj);
    }
}