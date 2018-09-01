package com.hackathon.julius.controller;

import com.hackathon.julius.dto.GastoDTO;
import com.hackathon.julius.entity.Gasto;
import com.hackathon.julius.repository.GastoRepository;
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
public class GastoController {

    @Autowired
    private GastoRepository gastoRepository;

    @GetMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Gasto>> getAll() {
        return ResponseEntity.ok(gastoRepository.findAll());
    }

    @GetMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Gasto> getById(@PathVariable("id") Integer id) {
        Optional<Gasto> opt =  gastoRepository.findById(id);

        return opt.isPresent() ? ResponseEntity.ok(opt.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Gasto> insert(@RequestBody @Valid GastoDTO gastoDTO) {
        Gasto gasto = new Gasto();

        gasto.setData(gastoDTO.getData());
        gasto.setDescricao(gastoDTO.getDescricao());
        gasto.setValor(gastoDTO.getValor());

        return ResponseEntity.status(HttpStatus.CREATED).body(gastoRepository.save(gasto));
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Gasto> update (@PathVariable("id") Integer id, @RequestBody GastoDTO gastoDTO) {
        Optional<Gasto> gastoOld = gastoRepository.findById(id);
        Gasto newGasto = new Gasto();

        if (gastoOld.isPresent()) {
            newGasto = gastoOld.get();
            newGasto.setData(gastoDTO.getData());
            newGasto.setDescricao(gastoDTO.getDescricao());
            newGasto.setValor(gastoDTO.getValor());
            gastoRepository.save(newGasto);
        }

        return gastoOld.isPresent() ? ResponseEntity.ok(newGasto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Gasto> update (@PathVariable("id") Integer id) {
        Optional<Gasto> gastoOld = gastoRepository.findById(id);
        gastoRepository.delete(gastoOld.get());

        return gastoOld.isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}


