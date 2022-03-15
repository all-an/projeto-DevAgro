package com.projeto.devagro.controllers;

import com.projeto.devagro.entities.Grao;
import com.projeto.devagro.response.Response;
import com.projeto.devagro.services.FazendaService;
import com.projeto.devagro.services.GraoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/graos")
public class GraoController {

    @Autowired
    private GraoService graoService;

    @Autowired
    private FazendaService fazendaService;

    @GetMapping
    public ResponseEntity<List<Grao>> encontrarTodos() {
        List<Grao> list = graoService.encontrarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Grao> encontrarPorId(@PathVariable Long id) {
        Grao grao = graoService.encontrarPorId(id);
        return ResponseEntity.ok().body(grao);
    }

    @PostMapping
    public ResponseEntity<Response<Grao>> cadastraGrao(@Valid @RequestBody Grao novo, BindingResult result) {
        Response<Grao> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(e -> response.getErros().add(e.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        Grao grao = graoService.adicionaGraoNoBancoENaEmpresa(novo);

        response.setDados(grao);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
