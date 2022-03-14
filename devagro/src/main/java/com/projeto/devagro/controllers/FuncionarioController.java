package com.projeto.devagro.controllers;

import com.projeto.devagro.entities.Funcionario;
import com.projeto.devagro.response.Response;
import com.projeto.devagro.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<Response<Funcionario>> cadastraFuncionario(@Valid @RequestBody Funcionario func,
                                                             BindingResult result) {
        Response<Funcionario> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(e -> response.getErros().add(e.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        Funcionario funcionario = service.inserir(func);

        response.setDados(funcionario);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}