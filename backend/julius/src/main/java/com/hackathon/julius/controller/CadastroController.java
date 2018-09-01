package com.hackathon.julius.controller;

import com.hackathon.julius.dto.ExtratoDTO;
import com.hackathon.julius.dto.GastoDTO;
import com.hackathon.julius.dto.PerguntaDTO;
import com.hackathon.julius.dto.ReceitaDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "cadastro")
public class CadastroController {

    @GetMapping(path = "perguntas",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PerguntaDTO> getPerguntas() throws Exception {

        List<PerguntaDTO> retorno =new ArrayList<PerguntaDTO>();

        retorno.add(new PerguntaDTO(1,"Como posso chamar você?"));
        retorno.add(new PerguntaDTO(2,"Desculpa a indelicadeza, mas quantos anos você tem?"));
        List<String> respostasPredefinidas = new ArrayList<String>();
        respostasPredefinidas.add("Sim");
        respostasPredefinidas.add("Nao");
        retorno.add(new PerguntaDTO(3,"Falando em brincadeira, você tem algum hobby?",respostasPredefinidas));
        List<String> respostasPredefinidas2 = new ArrayList<String>();
        respostasPredefinidas2.add("Jogar Futebol");
        respostasPredefinidas2.add("Dormir");
        retorno.add(new PerguntaDTO(4,"E qual o seu hobby favorito?",respostasPredefinidas2));
        List<String> respostasPredefinidas3 = new ArrayList<String>();
        respostasPredefinidas3.add("Em casa");
        respostasPredefinidas3.add("Rua");
        retorno.add(new PerguntaDTO(5,"E quando você não está praticando o seu hobby favorito, você passa mais tempo livre relaxando em casa ou na rua?",respostasPredefinidas3));
        List<String> respostasPredefinidas4 = new ArrayList<String>();
        respostasPredefinidas4.add("Quase! Estou financiando");
        respostasPredefinidas4.add("Própria");
        respostasPredefinidas4.add("Aluguel");
        retorno.add(new PerguntaDTO(6,"Falando em visita a sua casa é própria ou você paga aluguel?" ,respostasPredefinidas4));
        retorno.add(new PerguntaDTO(7,"Então Pedro, quanto você ganha em média por mês?"));
        return retorno;

    }
}
