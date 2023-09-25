package com.votacao.desafio.api.domain.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "pauta")
    private List<Voto> votos;

    private String descricao;


    public Pauta() {}

    public Pauta(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pauta)) return false;
        Pauta pauta = (Pauta) o;
        return Objects.equals(id, pauta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int contarVotosPositivos() {
        return (int) votos.stream().filter(Voto::getVoto).count();
    }

    public int contarVotosNegativos() {
        return (int) votos.stream().filter(v -> !v.getVoto()).count();
    }

    public String resultadoVotacao() {
        int votosPositivos = contarVotosPositivos();
        int votosNegativos = contarVotosNegativos();

        if (votosPositivos > votosNegativos) {
            return "Aprovação da Pauta";
        } else if (votosNegativos > votosPositivos) {
            return "Rejeição da Pauta";
        } else {
            return "Empate";
        }
    }
}
