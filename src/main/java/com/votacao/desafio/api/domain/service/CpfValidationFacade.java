package com.votacao.desafio.api.domain.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CpfValidationFacade {

    public ResponseEntity<String> validateCpf(String cpf) {
        Random random = new Random();

        // Simula a chance de CPF ser inválido (por exemplo, 10% de chance)
        if (random.nextInt(10) == 0) {
            return ResponseEntity.status(404).body("{\"status\": \"UNABLE_TO_VOTE\"}");
        }

        // Retorna se o usuário pode ou não votar
        if (random.nextBoolean()) {
            return ResponseEntity.ok("{\"status\": \"ABLE_TO_VOTE\"}");
        } else {
            return ResponseEntity.ok("{\"status\": \"UNABLE_TO_VOTE\"}");
        }
    }
}
