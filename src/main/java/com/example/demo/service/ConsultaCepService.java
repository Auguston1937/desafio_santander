package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cep;
import com.example.demo.repository.CepRepository;

@Service
public class ConsultaCepService {

    @Autowired
    private CepRepository cepRepository;

    @Autowired
    private RestTemplateService restTemplateService;

    public Cep consultaCep(String valorCep){
        Cep cep = restTemplateService.consultaCepApiExterna(valorCep);
        cepRepository.save(cep);
        return cep;
    }

    public List<Cep> consultaHistoricoCep() {
        List<Cep> list = new ArrayList<>();
        cepRepository.findAll().forEach(list::add);
        return list;
    }
}
