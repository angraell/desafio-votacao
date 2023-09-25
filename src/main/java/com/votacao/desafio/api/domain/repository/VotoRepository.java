package com.votacao.desafio.api.domain.repository;

import com.votacao.desafio.api.domain.entity.Associado;
import com.votacao.desafio.api.domain.entity.Pauta;
import com.votacao.desafio.api.domain.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

      boolean existsByAssociadoAndPauta(Associado associado, Pauta pauta);
}
