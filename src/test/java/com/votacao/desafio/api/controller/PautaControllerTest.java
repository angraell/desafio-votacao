package com.votacao.desafio.api.controller;


import com.votacao.desafio.api.domain.entity.Pauta;
import com.votacao.desafio.api.domain.service.PautaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PautaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PautaService pautaService;

    @Test
    void deveriaCriarUmaPauta() throws Exception {
        Pauta pauta = new Pauta("Descricao da Pauta");
        when(pautaService.salvar(any())).thenReturn(pauta);

        mockMvc.perform(MockMvcRequestBuilders.post("/pautas")
                        .contentType("application/json")
                        .content("{ \"descricao\": \"Descricao da Pauta\" }"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.descricao").value("Descricao da Pauta"));
    }
}
