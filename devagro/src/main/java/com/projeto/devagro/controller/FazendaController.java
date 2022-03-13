package com.projeto.devagro.controller;

import com.projeto.devagro.entity.Fazenda;
import com.projeto.devagro.service.FazendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/fazendas")
public class FazendaController {

    @Autowired
    private FazendaService service;

    @GetMapping
    public ResponseEntity<List<Fazenda>> encontrarTodas() {
        List<Fazenda> list = service.encontrarTodos();
        for(Fazenda f : list){
            f.calculaProximaColheita();
        }
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Fazenda> encontrarPorId(@PathVariable Long id) {
        Fazenda obj = service.encontrarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/colheita/{id}")
    public ResponseEntity<Fazenda> informaColheita(@PathVariable Long id, @RequestBody Fazenda fazenda) {
        fazenda = service.atualiza(id, fazenda);
        return ResponseEntity.ok().body(fazenda);
    }

    @PutMapping(value = "/retirarGraos/{id}")
    public ResponseEntity<Fazenda> registraRetiradaGraos(@PathVariable Long id, @RequestBody Fazenda fazenda) {
        fazenda = service.atualiza(id, fazenda);
        return ResponseEntity.ok().body(fazenda);
    }
}