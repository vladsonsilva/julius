package com.hackathon.julius.controller;

import com.hackathon.julius.dto.ObjetivoDTO;
import com.hackathon.julius.entity.Objetivo;
import com.hackathon.julius.repository.ObjetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "objetivos")
public class ObjetivoController {

    @Autowired
    private ObjetivoRepository objetivoRepository;

    @GetMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Objetivo>> getAll() {
        return ResponseEntity.ok(objetivoRepository.findAll());
    }

    @GetMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Objetivo> getById(@PathVariable("id") Integer id) {
        Optional<Objetivo> opt =  objetivoRepository.findById(id);

        return opt.isPresent() ? ResponseEntity.ok(opt.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Objetivo> insert(@RequestBody @Valid ObjetivoDTO objetivoDTO) {
        Objetivo objetivo = new Objetivo();

        objetivo.setDataEstipulada(objetivoDTO.getDataEstipulada());
        objetivo.setDescricao(objetivoDTO.getDescricao());
        objetivo.setValorEstipulado(objetivoDTO.getValorEstipulado());

        return ResponseEntity.status(HttpStatus.CREATED).body(objetivoRepository.save(objetivo));
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Objetivo> update (@PathVariable("id") Integer id, @RequestBody @Valid ObjetivoDTO objetivoDTO) {
        Optional<Objetivo> objetivoOld = objetivoRepository.findById(id);
        Objetivo newObjetivo = new Objetivo();

        if (objetivoOld.isPresent()) {
            newObjetivo = objetivoOld.get();
            newObjetivo.setDataEstipulada(objetivoDTO.getDataEstipulada());
            newObjetivo.setDescricao(objetivoDTO.getDescricao());
            newObjetivo.setValorEstipulado(objetivoDTO.getValorEstipulado());
            objetivoRepository.save(newObjetivo);
        }

        return objetivoOld.isPresent() ? ResponseEntity.ok(newObjetivo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Objetivo> update (@PathVariable("id") Integer id) {
        Optional<Objetivo> objetivoOld = objetivoRepository.findById(id);
        objetivoRepository.delete(objetivoOld.get());

        return objetivoOld.isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
