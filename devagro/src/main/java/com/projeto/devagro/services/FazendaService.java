package com.projeto.devagro.services;

import com.projeto.devagro.entities.Fazenda;
import com.projeto.devagro.repositories.FazendaRepository;
import com.projeto.devagro.services.exceptions.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class FazendaService {

    @Autowired
    private FazendaRepository repository;

    public List<Fazenda> encontrarTodos() {
        return repository.findAll();
    }

    public Fazenda encontrarPorId(Long id) {
        Optional<Fazenda> obj = repository.findById(id);
        return obj.get();
    }

    public Fazenda atualiza(Long id, Fazenda nova) {
        try {
            Fazenda antiga = repository.getById(id);
            atualizaDados(antiga, nova);
            return repository.save(antiga);
        } catch (EntityNotFoundException e) {
            throw new RecursoNaoEncontradoException(id); //404Not Found
        }
    }

    private void atualizaDados(Fazenda antiga, Fazenda nova) {
        antiga.setColheita(nova.getColheita());
        antiga.calculaRetiradaDeGraos(nova.getRetiradaDeGraos());
        antiga.setRetiradaDeGraos(nova.getRetiradaDeGraos());
        antiga.calculaProximaColheita();
    }
}