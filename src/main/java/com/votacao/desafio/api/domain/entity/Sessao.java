package com.votacao.desafio.api.domain.entity;



import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Sessao {

    public enum Status {
        ABERTA, FECHADA
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    @ManyToOne
    @JoinColumn(name = "pauta_id", referencedColumnName = "id")
    private Pauta pauta;

    @Enumerated(EnumType.STRING)
    private Status status;


    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sessao)) return false;
        Sessao sessao = (Sessao) o;
        return Objects.equals(id, sessao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
