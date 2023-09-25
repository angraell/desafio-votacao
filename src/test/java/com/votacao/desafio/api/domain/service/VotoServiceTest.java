package com.votacao.desafio.api.domain.service;

import com.votacao.desafio.api.domain.entity.Associado;
import com.votacao.desafio.api.domain.entity.Pauta;
import com.votacao.desafio.api.domain.entity.Voto;
import com.votacao.desafio.api.domain.repository.AssociadoRepository;
import com.votacao.desafio.api.domain.repository.PautaRepository;
import com.votacao.desafio.api.domain.repository.VotoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VotoServiceTest {

    @InjectMocks
    private VotoService votoService;

    @Mock
    private VotoRepository votoRepository;

    @Mock
    private AssociadoRepository associadoRepository;

    @Mock
    private PautaRepository pautaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldVoteSuccessfully() {
        Long associadoId = 1L;
        Long pautaId = 1L;
        Boolean voto = true;

        Associado associado = new Associado();
        Pauta pauta = new Pauta();

        when(associadoRepository.findById(associadoId)).thenReturn(Optional.of(associado));
        when(pautaRepository.findById(pautaId)).thenReturn(Optional.of(pauta));
        when(votoRepository.existsByAssociadoAndPauta(associado, pauta)).thenReturn(false);
        when(votoRepository.save(any(Voto.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Voto novoVoto = votoService.votar(associadoId, pautaId, voto);

        assertNotNull(novoVoto, "novoVoto is null");
        assertEquals(associado, novoVoto.getAssociado(), "Associado is not correct");
        assertEquals(pauta, novoVoto.getPauta(), "Pauta is not correct");
        assertEquals(voto, novoVoto.getVoto(), "Voto is not correct");

        verify(votoRepository).save(any(Voto.class));
    }



    @Test
    void shouldThrowExceptionWhenAssociadoAlreadyVoted() {
        Long associadoId = 1L;
        Long pautaId = 1L;
        Boolean voto = true;

        Associado associado = new Associado();
        Pauta pauta = new Pauta();

        when(associadoRepository.findById(associadoId)).thenReturn(Optional.of(associado));
        when(pautaRepository.findById(pautaId)).thenReturn(Optional.of(pauta));
        when(votoRepository.existsByAssociadoAndPauta(associado, pauta)).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> votoService.votar(associadoId, pautaId, voto));
    }
}
