package com.hackathon.julius.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ObjetivoDTO {

    @NotEmpty(message = "O campo descrição é obrigatório")
    private String descricao;

    @NotNull(message = "O campo data estipulada é obrigatório")
    private LocalDate dataEstipulada;

    @NotNull(message = "O campo valor estipulado é obrigatório")
    private Double valorEstipulado;

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

    public Double getValorEstipulado() {
        return valorEstipulado;
    }

    public void setValorEstipulado(Double valorEstipulado) {
        this.valorEstipulado = valorEstipulado;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("descricao", descricao)
                .append("dataEstipulada", dataEstipulada)
                .append("valorEstipulado", valorEstipulado)
                .toString();
    }
}
