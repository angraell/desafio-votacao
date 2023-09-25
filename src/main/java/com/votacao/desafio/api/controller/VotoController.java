package com.votacao.desafio.api.controller;

import com.votacao.desafio.api.domain.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.votacao.desafio.api.domain.entity.Voto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votos")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @PostMapping
    public ResponseEntity<Voto> votar(@RequestParam Long associadoId, @RequestParam Long pautaId, @RequestParam Boolean voto) {
        try {
            Voto votoSalvo = votoService.votar(associadoId, pautaId, voto);
            return ResponseEntity.ok(votoSalvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
