package com.votacao.desafio.api.domain.service;

import com.votacao.desafio.api.domain.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.votacao.desafio.api.domain.entity.Voto;
import org.springframework.transaction.annotation.Transactional;
import com.votacao.desafio.api.domain.entity.Associado;
import com.votacao.desafio.api.domain.entity.Pauta;
import com.votacao.desafio.api.domain.repository.AssociadoRepository;
import com.votacao.desafio.api.domain.repository.PautaRepository;


@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private AssociadoRepository associadoRepository;

    @Autowired
    private PautaRepository pautaRepository;

    public Voto votar(Long associadoId, Long pautaId, Boolean voto) {
        Associado associado = associadoRepository.findById(associadoId)
                .orElseThrow(() -> new IllegalArgumentException("Associado não encontrado"));

        Pauta pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new IllegalArgumentException("Pauta não encontrada"));

        if (votoRepository.existsByAssociadoAndPauta(associado, pauta)) {
            throw new IllegalArgumentException("Associado já votou nesta pauta");
        }

        Voto novoVoto = new Voto();
        novoVoto.setAssociado(associado);
        novoVoto.setPauta(pauta);
        novoVoto.setVoto(voto);

        return votoRepository.save(novoVoto);
    }

}
