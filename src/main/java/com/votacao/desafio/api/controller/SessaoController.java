package com.votacao.desafio.api.controller;

import com.votacao.desafio.api.domain.entity.Sessao;
import com.votacao.desafio.api.domain.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @PostMapping("/{pautaId}")
    public ResponseEntity<Sessao> abrirSessao(@PathVariable Long pautaId, @RequestParam(required = false) Duration duracao) {
        try {
            Sessao sessao = sessaoService.abrirSessao(pautaId, duracao);
            return ResponseEntity.ok(sessao);
        } catch (IllegalArgumentException e) {
            e.printStackTrace(); // Log the exception
            throw e; // Relançar a exceção para ser capturada pelo @ExceptionHandler
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
