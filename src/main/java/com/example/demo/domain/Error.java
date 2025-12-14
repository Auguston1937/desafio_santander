package com.example.demo.domain;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class Error implements Serializable {

    private String message;
    
}
