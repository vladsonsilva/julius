package com.hackathon.julius.controller;

import com.hackathon.julius.dto.ReceitaDTO;
import com.hackathon.julius.entity.Receita;
import com.hackathon.julius.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "receita")
public class ReceitaController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @GetMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Receita>> getAll() {
        return ResponseEntity.ok(receitaRepository.findAll());
    }

    @GetMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Receita> getById(@PathVariable("id") Integer id) {
        Optional<Receita> opt =  receitaRepository.findById(id);

        return opt.isPresent() ? ResponseEntity.ok(opt.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Receita> insert(@RequestBody @Valid ReceitaDTO receitaDTO) {
        Receita receita= new Receita();

        receita.setData(receitaDTO.getData());
        receita.setDescricao(receitaDTO.getDescricao());
        receita.setValor(receitaDTO.getValor());

        return ResponseEntity.status(HttpStatus.CREATED).body(receitaRepository.save(receita));
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Receita> update (@PathVariable("id") Integer id, @RequestBody @Valid ReceitaDTO receitaDTO) {
        Optional<Receita> receitaOld = receitaRepository.findById(id);
        Receita newReceita = new Receita();

        if (receitaOld.isPresent()) {
            newReceita = receitaOld.get();
            newReceita.setData(receitaDTO.getData());
            newReceita.setDescricao(receitaDTO.getDescricao());
            newReceita.setValor(receitaDTO.getValor());
            receitaRepository.save(newReceita);
        }

        return receitaOld.isPresent() ? ResponseEntity.ok(newReceita) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Receita> delete (@PathVariable("id") Integer id) {
        Optional<Receita> receitaOld = receitaRepository.findById(id);
        receitaRepository.delete(receitaOld.get());

        return receitaOld.isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}


