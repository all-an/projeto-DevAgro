package com.projeto.devagro.controllers;

import com.projeto.devagro.entities.Empresa;
import com.projeto.devagro.entities.Fazenda;
import com.projeto.devagro.entities.Grao;
import com.projeto.devagro.response.Response;
import com.projeto.devagro.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


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
        Empresa obj = service.encontrarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/fazendas/{id}")
    public ResponseEntity<List<Fazenda>> encontraFazendasPorEmpresaId(@PathVariable Long id) {
        Empresa obj = service.encontrarPorId(id);
        List<Fazenda> lista = obj.getFazendas();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/quantidadeFazendas/{id}")
    public ResponseEntity<HashMap<String, String>> quantidadeFazendasDeUmaEmpresa(@PathVariable Long id) {
        Empresa obj = service.encontrarPorId(id);
        List<Fazenda> lista = obj.getFazendas();
        Integer total = lista.size();
        HashMap<String, String> map = new HashMap<>();
        map.put("Empresa: ", obj.getNome());
        map.put("Quantidade de Fazendas", total.toString());
        return ResponseEntity.ok().body(map);
    }

    @GetMapping(value = "/proximasColheitas/{id}")
    public ResponseEntity<List<LinkedHashMap<String, String>>> fazendasDataPrevistaProximaColheita(@PathVariable Long id) {
        Empresa obj = service.encontrarPorId(id);
        List<Fazenda> lista = obj.getFazendas();
        List<LinkedHashMap<String, String>> retorno = new ArrayList<>();
        for(Fazenda f : lista){
            LinkedHashMap<String, String> map = new LinkedHashMap<>();
            map.put("Id da Fazenda: ", f.getId().toString());
            map.put("Nome da Fazenda: ", f.getNome());
            map.put("Data Próxima Colheita: ", f.calculaProximaColheita().toString());
            retorno.add(map);
        }
        return ResponseEntity.ok().body(retorno);
    }

    @GetMapping(value = "/graos/{id}")
    public ResponseEntity<List<Grao>> retornaListaGraosEmpresa(@PathVariable Long id) {
        Empresa obj = service.encontrarPorId(id);
        List<Fazenda> listaFazendas = obj.getFazendas();
        List<Grao> listaGraos = new ArrayList<>();
        for(Fazenda f : listaFazendas){
            listaGraos.add(f.getGrao());
        }
        return ResponseEntity.ok().body(listaGraos);
    }

    //fonte onde encontrei o retorno em ordem crescente que está em service
    //https://howtodoinjava.com/java/sort/java-sort-map-by-values/
    @GetMapping(value = "/estoquesGraos/{id}")
    public ResponseEntity<LinkedHashMap<String, Double>> estoqueDeGraosOrdemCrescente(@PathVariable Long id) {
        Empresa obj = service.encontrarPorId(id);
        LinkedHashMap<String, Double> lista = service.graosOrdemCrescente(obj);
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<Response<Empresa>> cadastraEmpresa(@Valid @RequestBody Empresa emp,
                                                             BindingResult result) {
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