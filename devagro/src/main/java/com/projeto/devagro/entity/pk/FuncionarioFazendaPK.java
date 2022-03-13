package com.projeto.devagro.entity.pk;

import com.projeto.devagro.entity.Fazenda;
import com.projeto.devagro.entity.Funcionario;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class FuncionarioFazendaPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "fazenda_id")
    private Fazenda fazenda;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public Fazenda getFazenda() {
        return fazenda;
    }
    public void setFazenda(Fazenda fazenda) {
        this.fazenda = fazenda;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fazenda == null) ? 0 : fazenda.hashCode());
        result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
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
        FuncionarioFazendaPK other = (FuncionarioFazendaPK) obj;
        if (fazenda == null) {
            if (other.fazenda != null)
                return false;
        } else if (!fazenda.equals(other.fazenda))
            return false;
        if (funcionario == null) {
            if (other.funcionario != null)
                return false;
        } else if (!funcionario.equals(other.funcionario))
            return false;
        return true;
    }
}