package com.hackathon.julius.entity;

import javax.persistence.*;

@Entity
public class RespostaPreDefinida {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String resposta;

    public RespostaPreDefinida() {

    }

    public RespostaPreDefinida(String resposta) {
        this.resposta = resposta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
