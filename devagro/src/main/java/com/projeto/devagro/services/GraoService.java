package com.projeto.devagro.services;

import com.projeto.devagro.entities.Empresa;
import com.projeto.devagro.entities.Grao;
import com.projeto.devagro.repositories.GraoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GraoService {

    @Autowired
    private GraoRepository graoRepository;

    @Autowired
    private EmpresaService empresaService;

    public List<Grao> encontrarTodos() {
        return graoRepository.findAll();
    }

    public Grao encontrarPorId(Long id) {
        Optional<Grao> obj = graoRepository.findById(id);
        return obj.get();
    }

    public Grao inserir(Grao grao) {
        return graoRepository.save(grao);
    }

    public Grao adicionaGraoNoBancoENaEmpresa(Grao grao){
        Empresa empresa = grao.getEmpresas().stream().findFirst().get();
        Grao g = new Grao(null, grao.getNome(), grao.getTempoMedioColheita(), empresa);
        empresa.addGraos(g);
        empresaService.atualizar(empresa.getId(), empresa);
        return inserir(g);
    }
}
