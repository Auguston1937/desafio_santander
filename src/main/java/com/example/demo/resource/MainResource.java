package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Cep;
import com.example.demo.service.ConsultaCepService;

@RestController
@RequestMapping("/consulta_cep")
public class MainResource {

    @Autowired
    private ConsultaCepService consultaCepService;

    @GetMapping("/{valorCep}")
    public ResponseEntity<Cep> consultaCep(@PathVariable("valorCep") String valorCep){
        return new ResponseEntity<Cep>(consultaCepService.consultaCep(valorCep), HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<Cep>> consultaHistoricoCep(){
        return new ResponseEntity<List<Cep>>(consultaCepService.consultaHistoricoCep(), HttpStatusCode.valueOf(200));
    }
    
}
