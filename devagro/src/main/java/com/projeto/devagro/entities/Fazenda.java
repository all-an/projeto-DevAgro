package com.projeto.devagro.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_fazenda")
public class Fazenda implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String endereco;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant dataUltimaColheita;

    private Instant dataPrivistaProximaColheita;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "grao_id", referencedColumnName = "id")
    private Grao grao;

    private Double estoqueInicialGraos = 0.0;

    private Double colheita = 0.0;

    private Double retiradaDeGraos = 0.0;

    public Fazenda() {
    }

    public Fazenda(Long id, String nome, String endereco, Grao grao, Instant dataUlTimaColheita, Empresa empresa, Double estoqueInicialGraos) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.grao = grao;
        this.dataUltimaColheita = dataUlTimaColheita;
        this.empresa = empresa;
        this.estoqueInicialGraos = estoqueInicialGraos;
        this.dataPrivistaProximaColheita = dataUlTimaColheita.plusSeconds(grao.getTempoMedioColheita() * 86400);
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Instant getDataUltimaColheita() {
        return dataUltimaColheita;
    }

    public void setDataUltimaColheita(Instant dataUlTimaColheita) {
        this.dataUltimaColheita = dataUlTimaColheita;
    }

    public Instant getDataPrivistaProximaColheita() {
        return dataPrivistaProximaColheita;
    }

    public void setDataPrivistaProximaColheita() {
        this.dataPrivistaProximaColheita = calculaProximaColheita();
    }

    public Instant calculaProximaColheita(){
        Integer segundos = grao.getTempoMedioColheita() * 86400;
        dataPrivistaProximaColheita = dataUltimaColheita.plusSeconds(segundos);
        return dataPrivistaProximaColheita;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Grao getGrao() {
        return grao;
    }

    public void setGrao(Grao grao) {
        this.grao = grao;
    }

    public Double getEstoqueInicialGraos() {
        return estoqueInicialGraos;
    }

    public void setEstoqueInicialGraos(Double estoqueInicialGraos) {
        this.estoqueInicialGraos = estoqueInicialGraos;
    }

    public Double getColheita() {
        return colheita;
    }

    public void setColheita(Double colheita) {
        this.colheita = colheita;
        this.estoqueInicialGraos += colheita;
        this.dataUltimaColheita = Instant.now();
    }

    public Double getRetiradaDeGraos(){
        return retiradaDeGraos;
    }

    public void setRetiradaDeGraos(Double graosRetirados){
        this.retiradaDeGraos = graosRetirados;
    }

    public void calculaRetiradaDeGraos(Double graosRetirados){
        this.estoqueInicialGraos -= graosRetirados;
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
        Fazenda other = (Fazenda) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


}
