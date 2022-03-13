package com.projeto.devagro.controllers;

import com.projeto.devagro.entities.Fazenda;
import com.projeto.devagro.response.Response;
import com.projeto.devagro.services.FazendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<Response<Fazenda>> cadastraFazenda(@Valid @RequestBody Fazenda fazenda,
                                                             BindingResult result) {
        Response<Fazenda> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(e -> response.getErros().add(e.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        Fazenda fazen = service.inserir(fazenda);

        response.setDados(fazen);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
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