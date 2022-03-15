package com.projeto.devagro.services;

import com.projeto.devagro.entities.Empresa;
import com.projeto.devagro.entities.Fazenda;
import com.projeto.devagro.entities.Funcionario;
import com.projeto.devagro.repositories.EmpresaRepository;
import com.projeto.devagro.services.exceptions.BancoDeDadosException;
import com.projeto.devagro.services.exceptions.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;


@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    public List<Empresa> encontrarTodos() {
        return repository.findAll();
    }

    public Empresa encontrarPorId(Long id) {
        Optional<Empresa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id));
    }

    public Empresa inserir(Empresa empresa) {
        return repository.save(empresa);
    }

    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RecursoNaoEncontradoException(id);
        } catch (DataIntegrityViolationException e) {
            throw new BancoDeDadosException(e.getMessage());
        }
    }

    public Empresa atualizar(Long id, Empresa nova) {
        try {
            Empresa antiga = repository.getById(id);
            atualizarDados(antiga, nova);
            return repository.save(antiga);
        } catch (EntityNotFoundException e) {
            throw new RecursoNaoEncontradoException(id); //404Not Found
        }
    }

    //fonte onde encontrei o retorno em ordem crescente
    //https://howtodoinjava.com/java/sort/java-sort-map-by-values/
    public LinkedHashMap<String, Double> graosOrdemCrescente(Empresa empresa){
        List<Fazenda> lista = empresa.getFazendas();
        Map<String, Double> semOrdem = new HashMap<>();
        LinkedHashMap<String, Double> retornoOrdenado = new LinkedHashMap<>();
        for(Fazenda f : lista){
            semOrdem.put("Grão: " + f.getGrao().getNome(), f.getEstoqueInicialGraos());
        }
        semOrdem.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> retornoOrdenado.put(x.getKey(), x.getValue()));
        return retornoOrdenado;
    }

    public List<Funcionario> listaTodosFuncionarios(Empresa emp){
        List<Funcionario> listaFun = emp.getFuncionarios();
        return listaFun;
    }

    public Integer quantidadeFuncionarios(Empresa emp){
        List<Funcionario> listaFun = emp.getFuncionarios();
        Integer quant = listaFun.size();
        return quant;
    }

    private void atualizarDados(Empresa atual, Empresa nova) {
        atual.setNome(nova.getNome());
        atual.setCnpj(nova.getCnpj());
        atual.setEndereco(nova.getEndereco());
    }




}