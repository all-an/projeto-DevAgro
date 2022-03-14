package com.projeto.devagro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_empresa")
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @CNPJ
    @Pattern(regexp="\\d{2}.?\\d{3}.?\\d{3}/?\\d{4}-?\\d{2}", message = "Formate assim CNPJ XX.XXX.XXX/XXXX-XX")
    private String cnpj;

    private String endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private List<Fazenda> fazendas = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private List<Funcionario> funcionarios = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "empresas")
    private Set<Grao> graos = new HashSet<>();

    public Empresa() {
    }

    public Empresa(Long id, String nome, String cnpj, String endereco) {
        super();
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Fazenda> getFazendas() {
        return fazendas;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
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
        Empresa other = (Empresa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}