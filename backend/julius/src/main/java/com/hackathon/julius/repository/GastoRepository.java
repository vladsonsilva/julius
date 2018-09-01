package com.hackathon.julius.repository;

import com.hackathon.julius.entity.Gasto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GastoRepository extends CrudRepository<Gasto, Integer> {

    public List<Gasto> findAll();
}
