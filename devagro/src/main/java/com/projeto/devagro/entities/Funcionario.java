
package com.projeto.devagro.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.devagro.entities.enums.Sexo;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private Integer sexo;
    private String endereco;
    private Double salario;

    @Pattern(regexp="^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}[0-9]{4}$", message = "Deve ser um formato válido (XX) XXXXXXXXX")
    private String telefone;

    @Pattern(regexp="(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2}", message = "Deve ser um formato válido dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private String nascimento;

    @Pattern(regexp="(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2}", message = "Deve ser um formato válido dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private String contratacao;

    @ManyToMany
    @JoinTable(name = "tb_funcionario_funcao", joinColumns = @JoinColumn(name = "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "funcao_id"))
    private Set<Funcao> funcoes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String sobrenome, Sexo sexo, String endereco, Double salario, String telefone, String nascimento, String contratacao, Empresa empresa) {
        super();
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        setSexo(sexo);
        this.endereco = endereco;
        this.salario = salario;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.contratacao = contratacao;
        this.empresa = empresa;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Sexo getSexo() {
        return Sexo.valueOf(sexo);
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setSexo(Sexo sexo) {
        if (sexo != null) {
            this.sexo = sexo.getCodigo();
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Set<Funcao> getFuncoes() {
        return funcoes;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getContratacao() {
        return contratacao;
    }

    public void setContratacao(String contratacao) {
        this.contratacao = contratacao;
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
        Funcionario other = (Funcionario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}