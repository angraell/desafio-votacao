package com.votacao.desafio.api.domain.service;


import com.votacao.desafio.api.domain.entity.Pauta;
import com.votacao.desafio.api.domain.repository.PautaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class PautaServiceTest {

    @InjectMocks
    PautaService pautaService;

    @Mock
    PautaRepository pautaRepository;

    @Test
    void deveriaSalvarPauta() {
        Pauta pauta = new Pauta("Descricao da Pauta");
        when(pautaRepository.save(any())).thenReturn(pauta);

        Pauta pautaSalva = pautaService.salvar(pauta);

        verify(pautaRepository, times(1)).save(pauta);
    }
}
