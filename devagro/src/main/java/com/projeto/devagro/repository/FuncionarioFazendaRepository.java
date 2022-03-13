package com.projeto.devagro.repository;

import com.projeto.devagro.entity.FuncionarioFazenda;
import com.projeto.devagro.entity.pk.FuncionarioFazendaPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioFazendaRepository extends JpaRepository<FuncionarioFazenda, FuncionarioFazendaPK> {
}
