package com.votacao.desafio.api.domain.repository;

import com.votacao.desafio.api.domain.entity.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {}
