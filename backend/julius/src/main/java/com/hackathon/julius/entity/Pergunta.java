package com.hackathon.julius.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String pergunta;

    @OneToMany(targetEntity = RespostaPreDefinida.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<RespostaPreDefinida> respostasPredefinidas;

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

    public List<RespostaPreDefinida> getRespostasPredefinidas() {
        return respostasPredefinidas;
    }

    public void setRespostasPredefinidas(List<RespostaPreDefinida> respostasPredefinidas) {
        this.respostasPredefinidas = respostasPredefinidas;
    }

    @Override
    public String toString() {
        return "Pergunta{" +
                "id=" + id +
                ", pergunta='" + pergunta + '\'' +
                ", respostasPredefinidas=" + respostasPredefinidas +
                '}';
    }
}
