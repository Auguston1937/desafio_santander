package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Cep;

@Repository
public interface CepRepository extends CrudRepository<Cep, String>{
    
}
