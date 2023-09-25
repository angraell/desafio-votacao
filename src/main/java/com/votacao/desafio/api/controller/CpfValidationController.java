package com.votacao.desafio.api.controller;

import com.votacao.desafio.api.domain.service.CpfValidationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cpf-validation")
public class CpfValidationController {

    private final CpfValidationFacade cpfValidationFacade;

    @Autowired
    public CpfValidationController(CpfValidationFacade cpfValidationFacade) {
        this.cpfValidationFacade = cpfValidationFacade;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<String> validateCpf(@PathVariable String cpf) {
        return cpfValidationFacade.validateCpf(cpf);
    }
}
