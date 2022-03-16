package com.projeto.devagro.controllers;

import com.projeto.devagro.entities.*;
import com.projeto.devagro.response.Response;
import com.projeto.devagro.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @GetMapping
    public ResponseEntity<List<Empresa>> encontraTodas() {
        List<Empresa> list = service.encontrarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Empresa> encontraEmpresaPorId(@PathVariable Long id) {
        Empresa emp = service.encontrarPorId(id);
        return ResponseEntity.ok().body(emp);
    }

    @GetMapping(value = "/fazendas/{id}")
    public ResponseEntity<List<Fazenda>> encontraFazendasPorEmpresaId(@PathVariable Long id) {
        Empresa emp = service.encontrarPorId(id);
        List<Fazenda> lista = emp.getFazendas();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/quantidadeFazendas/{id}")
    public ResponseEntity<HashMap<String, String>> quantidadeFazendasDeUmaEmpresa(@PathVariable Long id) {
        HashMap<String, String> map = service.retornaFazendasDeEmpresa(id);
        return ResponseEntity.ok().body(map);
    }

    @GetMapping(value = "/proximasColheitas/{id}")
    public ResponseEntity<List<LinkedHashMap<String, String>>> fazendasDataPrevistaProximaColheita(@PathVariable Long id) {
        List<LinkedHashMap<String, String>> retorno = service.retornaFazendasProximasColheitas(id);
        return ResponseEntity.ok().body(retorno);
    }

    @GetMapping(value = "/graos/{id}")
    public ResponseEntity<List<Grao>> retornaListaGraosEmpresa(@PathVariable Long id) {
        List<Grao> listaGraos = service.listaGraosEmpresa(id);
        return ResponseEntity.ok().body(listaGraos);
    }

    //fonte onde encontrei o retorno em ordem crescente que está em service
    //https://howtodoinjava.com/java/sort/java-sort-map-by-values/
    @GetMapping(value = "/estoquesGraos/{id}")
    public ResponseEntity<LinkedHashMap<String, Double>> estoqueDeGraosOrdemCrescente(@PathVariable Long id) {
        Empresa emp = service.encontrarPorId(id);
        LinkedHashMap<String, Double> lista = service.graosOrdemCrescente(emp);
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/listaFuncionarios/{id}")
    public ResponseEntity<List<Funcionario>> listaFuncionarios(@PathVariable Long id) {
        Empresa emp = service.encontrarPorId(id);
        List<Funcionario> lista = service.listaTodosFuncionarios(emp);
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/quantidadeFuncionarios/{id}")
    public ResponseEntity<LinkedHashMap<String, String>> quantidadeFuncionarios(@PathVariable Long id) {
        LinkedHashMap<String, String> map1 = service.todosFuncionariosEmpresa(id);
        return ResponseEntity.ok().body(map1);
    }

    @PostMapping
    public ResponseEntity<Response<Empresa>> cadastraEmpresa(@Valid @RequestBody Empresa emp, BindingResult result) {
        Response<Empresa> response = new Response<>();
        if (result.hasErrors()) {
            result.getAllErrors().forEach(e -> response.getErros().add(e.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        Empresa empresa = service.inserir(emp);
        response.setDados(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Empresa> atualizar(@PathVariable Long id, @RequestBody Empresa nova) {
        nova = service.atualizar(id, nova);
        return ResponseEntity.ok().body(nova);
    }
}