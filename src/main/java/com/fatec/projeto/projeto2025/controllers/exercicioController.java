package com.fatec.projeto.projeto2025.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class exercicioController {

    @GetMapping("")
    public String Helloworld(){
        return "Hello";
    }


    @GetMapping("{nome}")
    public String Helloworld(@PathVariable Optional<String> nome){
        return nome.isPresent() ? nome.get() : "dd";
    }
}
