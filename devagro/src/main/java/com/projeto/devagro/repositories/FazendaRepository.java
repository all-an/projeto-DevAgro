package com.projeto.devagro.repositories;

import com.projeto.devagro.entities.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FazendaRepository extends JpaRepository<Fazenda, Long> {
}