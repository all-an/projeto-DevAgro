package com.projeto.devagro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_grao")
public class Grao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer tempoMedioColheita;

    @JsonIgnore
    @OneToMany(mappedBy = "grao")
    private Set<Fazenda> fazendas = new HashSet<>();

    @NotNull(message = "Favor preencher a empresa")
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    private Empresa empresa;

    public Grao() {
    }

    public Grao(Long id, String nome, Integer tempoColheita, Empresa empresa) {
        this.id = id;
        this.nome = nome;
        this.tempoMedioColheita = tempoColheita;
        this.empresa = empresa;
        empresa.addGraos(this);
//        empresas.add(empresa);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTempoMedioColheita() {
        return tempoMedioColheita;
    }

    public void setTempoMedioColheita(Integer tempoMedioColheita) {
        this.tempoMedioColheita = tempoMedioColheita;
    }

    public Set<Fazenda> getFazendas() {
        return fazendas;
    }

    public void addFazenda(Fazenda fazenda) {

        fazendas.add(fazenda);

    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    //    public void addEmpresa(Empresa empresa){
//        empresas.add(empresa);
//    }
//
//    public Set<Empresa> getEmpresas() {
//        return empresas;
//    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Grao other = (Grao) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
