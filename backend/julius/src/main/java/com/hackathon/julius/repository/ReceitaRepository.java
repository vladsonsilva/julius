package com.hackathon.julius.repository;

import com.hackathon.julius.entity.Receita;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReceitaRepository extends CrudRepository<Receita, Integer> {

    public List<Receita> findAll();
}
