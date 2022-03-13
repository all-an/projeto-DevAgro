package com.projeto.devagro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.devagro.entity.pk.FuncionarioFazendaPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_funcionario_fazenda")
public class FuncionarioFazenda implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private FuncionarioFazendaPK id = new FuncionarioFazendaPK();

    private Integer numeroDeFuncionarios;
    private Double salarioIndividual;
    private Double custoSubtotal;

    public FuncionarioFazenda() {
    }

    public FuncionarioFazenda(Fazenda fazenda, Funcionario funcionario, Integer numeroDeFuncionarios, Double salarioIndividual) {
        id.setFazenda(fazenda);
        id.setFuncionario(funcionario);
        this.numeroDeFuncionarios = numeroDeFuncionarios;
        this.salarioIndividual = salarioIndividual;
        this.custoSubtotal = salarioIndividual * numeroDeFuncionarios;
    }

    @JsonIgnore
    public Fazenda getFazenda() {
        return id.getFazenda();
    }

    public void setFazenda(Fazenda fazenda) {
        id.setFazenda(fazenda);
    }

    public Funcionario getFuncionario() {
        return id.getFuncionario();
    }

    public void setFuncionario(Funcionario funcionario) {
        id.setFuncionario(funcionario);
    }

    public Integer getNumerodeFuncionarios() {
        return numeroDeFuncionarios;
    }

    public void setNumerodeFuncionarios(Integer numerodeFuncionarios) {
        this.numeroDeFuncionarios = numerodeFuncionarios;
    }

    public Double getSalarioIndividual() {
        return salarioIndividual;
    }

    public void setSalarioIndividual(Double salarioIndividual) {
        this.salarioIndividual = salarioIndividual;
    }

    public Double getSubTotal() {
        return salarioIndividual * numeroDeFuncionarios;
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
        FuncionarioFazenda other = (FuncionarioFazenda) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
