package com.votacao.desafio.api.domain.entity;


import jakarta.persistence.*;

@Entity
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "associado_id")
    private Associado associado;

    @ManyToOne
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;

    private Boolean voto;

    // Construtor, getters e setters
    // ...

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public Boolean getVoto() {
        return voto;
    }

    public void setVoto(Boolean voto) {
        this.voto = voto;
    }
}
