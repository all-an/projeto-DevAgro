package com.projeto.devagro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_grao")
public class Grao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer tempoMedioColheita;
    private String nomeEmpresa;
    private Instant dataUltimaColheita;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Fazenda fazenda;

    public Grao() {
    }

    public Grao(Long id, String nome, Integer tempoColheita, Fazenda fazenda) {
        super();
        this.id = id;
        this.nome = nome;
        this.tempoMedioColheita = tempoColheita;
        this.nomeEmpresa = fazenda.getEmpresa().getNome();
        this.dataUltimaColheita = fazenda.getDataUltimaColheita();
        this.fazenda = fazenda;
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

    public Instant getdataColheita() {
        return dataUltimaColheita;
    }

    public void setdataColheita(Instant dataColheita) {
        this.dataUltimaColheita = dataUltimaColheita;
    }

    public Fazenda getFazenda() {
        return fazenda;
    }

    public void setFazenda(Fazenda fazenda) {
        this.fazenda = this.fazenda;
    }

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
