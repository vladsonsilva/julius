package com.hackathon.julius.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
public class RespostaPreDefinida {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    @ManyToOne(targetEntity = PontoResposta.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PontoResposta> pontos;

    @Column(nullable = false)
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PontoResposta> getPontos() {
        return pontos;
    }

    public void setPontos(List<PontoResposta> pontos) {
        this.pontos = pontos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("pontos", pontos)
                .append("descricao", descricao)
                .toString();
    }
}
