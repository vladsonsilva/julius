package com.hackathon.julius.repository;

import com.hackathon.julius.entity.Objetivo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ObjetivoRepository extends CrudRepository<Objetivo, Integer> {

    public List<Objetivo> findAll();
}
