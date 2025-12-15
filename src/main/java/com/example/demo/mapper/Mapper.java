package com.example.demo.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.demo.domain.Cep;
import com.example.demo.domain.Error;
import com.google.gson.Gson;

@Component
public class Mapper {

    Gson gson = new Gson();

    public Cep stringToExistingCep(String rawCep){
        Cep cep = gson.fromJson(rawCep, Cep.class);
        cep.setDataHora(LocalDateTime.now().toString());
        return cep;
    }

    public Cep stringToNonExistingCep(String valorCep, String errorMessage){
        // Error error = gson.fromJson(errorMessage, Error.class);
        Cep cep = new Cep();
        cep.setCep(valorCep);
        cep.setLogradouro("CEP não localizado!");
        cep.setDataHora(LocalDateTime.now().toString());
        return cep;
    }

}
