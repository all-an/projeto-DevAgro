package com.projeto.devagro.repositories;

import com.projeto.devagro.entities.FuncionarioFazenda;
import com.projeto.devagro.entities.pk.FuncionarioFazendaPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioFazendaRepository extends JpaRepository<FuncionarioFazenda, FuncionarioFazendaPK> {
}
