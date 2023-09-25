package com.votacao.desafio.api.controller;


import com.votacao.desafio.api.domain.entity.Pauta;
import com.votacao.desafio.api.domain.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pautas")
public class PautaController {

    private final PautaService pautaService;

    @Autowired
    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping
    public ResponseEntity<Pauta> criar(@RequestBody Pauta pauta) {
        Pauta pautaSalva = pautaService.salvar(pauta);
        return ResponseEntity.ok(pautaSalva);
    }

    @GetMapping("/{pautaId}/resultado")
    public ResponseEntity<String> resultadoVotacao(@PathVariable Long pautaId) {
        try {
            String resultado = pautaService.resultadoVotacao(pautaId);
            return ResponseEntity.ok(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
