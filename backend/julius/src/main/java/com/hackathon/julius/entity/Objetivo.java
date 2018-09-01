package com.hackathon.julius.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Objetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String descricao;
    private LocalDate dataEstipulada;
    private Integer valorEstipulado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataEstipulada() {
        return dataEstipulada;
    }

    public void setDataEstipulada(LocalDate dataEstipulada) {
        this.dataEstipulada = dataEstipulada;
    }

    public Integer getValorEstipulado() {
        return valorEstipulado;
    }

    public void setValorEstipulado(Integer valorEstipulado) {
        this.valorEstipulado = valorEstipulado;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("descricao", descricao)
                .append("dataEstipulada", dataEstipulada)
                .append("valorEstipulado", valorEstipulado)
                .toString();
    }
}
