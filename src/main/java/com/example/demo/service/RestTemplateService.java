package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.Cep;
import com.example.demo.mapper.Mapper;

@Service
public class RestTemplateService {

    @Autowired
    private Mapper mapper;

    public Cep consultaCepApiExterna(String valorCep){
        RestTemplate restTemplate = new RestTemplate();
        Cep cepResponse = new Cep();
        try {
            ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8081/consulta_cep/".concat(valorCep), String.class);
            cepResponse = mapper.stringToExistingCep(response.getBody());
        } catch (HttpClientErrorException e) {
            cepResponse = mapper.stringToNonExistingCep(valorCep, e.getResponseBodyAsString());
        }
        return cepResponse;
    }
    
}
