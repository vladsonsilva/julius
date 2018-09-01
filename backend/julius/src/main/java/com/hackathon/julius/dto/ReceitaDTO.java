package com.hackathon.julius.dto;

import java.time.LocalDate;

public class ReceitaDTO {

    private Integer id;
    private String descricao;
    private LocalDate data;
    private Double valor;

    public ReceitaDTO(Integer id, String descricao, Double valor, LocalDate data){
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
