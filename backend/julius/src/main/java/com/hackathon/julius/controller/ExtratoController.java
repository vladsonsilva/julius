package com.hackathon.julius.controller;

import com.hackathon.julius.dto.ExtratoDTO;
import com.hackathon.julius.dto.GastoDTO;
import com.hackathon.julius.dto.ReceitaDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "extrato")
public class ExtratoController {

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ExtratoDTO getMonitorStatus() throws Exception {

        ExtratoDTO retorno = new ExtratoDTO();

        ReceitaDTO receita = new ReceitaDTO(1, "Salário", 2000.00, LocalDate.of(2018, 8, 10));


        retorno.getReceitas().add(receita);

        ReceitaDTO receita2 = new ReceitaDTO(2, "Venda Bike", 200.00, LocalDate.of(2018, 8, 17));

        retorno.getReceitas().add(receita2);


        GastoDTO gasto1 = new GastoDTO(1, "Onibus", 4.35, LocalDate.now());

        retorno.getGastos().add(gasto1);

        GastoDTO gasto2 = new GastoDTO(2, "Trem", 3.20, LocalDate.now());

        retorno.getGastos().add(gasto2);

        GastoDTO gasto3 = new GastoDTO(3, "Almoço", 12.90, LocalDate.now());

        retorno.getGastos().add(gasto3);

        return retorno;

    }
}
