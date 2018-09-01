package com.hackathon.julius.dto;

import java.util.ArrayList;
import java.util.List;

public class ExtratoDTO {

    private List<GastoDTO> gastos;

    private List<ReceitaDTO> receitas;

    public ExtratoDTO(){
        gastos = new ArrayList<GastoDTO>();
        receitas =new ArrayList<ReceitaDTO>();
    }

    public Double getSaldo(){
        Double saldo = 0.0;

        for (ReceitaDTO r : receitas){
            saldo = saldo + r.getValor();
        }


        for (GastoDTO g : gastos){
            saldo = saldo - g.getValor();
        }

        return saldo;
    }

    public List<GastoDTO> getGastos() {
        return gastos;
    }

    public void setGastos(List<GastoDTO> gastos) {
        this.gastos = gastos;
    }

    public List<ReceitaDTO> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<ReceitaDTO> receitas) {
        this.receitas = receitas;
    }
}
