package com.votacao.desafio.api.domain.service;


import com.votacao.desafio.api.domain.entity.Pauta;
import com.votacao.desafio.api.domain.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PautaService {

    private final PautaRepository pautaRepository;

    @Autowired
    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public Pauta salvar(Pauta pauta) {
        return pautaRepository.save(pauta);
    }


    public String resultadoVotacao(Long pautaId) {
        Pauta pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new IllegalArgumentException("Pauta não encontrada"));
        return pauta.resultadoVotacao();
    }
}
