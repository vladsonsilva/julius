package com.hackathon.julius.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class PerguntaDTO {
    private Integer id;

    @NotEmpty(message = "O campo pergunta é obrigatório")
    private String pergunta;

    private List<String> respostasPredefinidas;
    public PerguntaDTO(){}
    public PerguntaDTO(Integer id,String pergunta){
        this.pergunta = pergunta;
        this.id = id;
        this.respostasPredefinidas = new ArrayList<String>();
    }
    public PerguntaDTO(Integer id,String pergunta, List<String> respostasPredefinidas){
        this.pergunta = pergunta;
        this.id = id;
        this.respostasPredefinidas = respostasPredefinidas;
    }

    public List<String> getRespostasPredefinidas() {
        return respostasPredefinidas;
    }

    public void setRespostasPredefinidas(List<String> respostasPredefinidas) {
        this.respostasPredefinidas = respostasPredefinidas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
}
