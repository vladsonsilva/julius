package com.hackathon.julius.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class GastoDTO {

    private Integer id;

    @NotEmpty(message = "O campo descrição é obrigatório.")
    private String descricao;

    @NotNull(message = "O campo data é obrigatório")
    private LocalDate data;

    @NotNull(message = "O campo valor é obrigatório")
    private Double valor;

    public GastoDTO() {
    }

    public GastoDTO(Integer id, String descricao, Double valor, LocalDate data){
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;

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
