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

   @GetMapping("/get-idade/{idade}")
  public String verificaIdade(@PathVariable Optional<String> idade){
        idade.ifPresent(value -> System.out.println("Idade: " + value));
        int idadeInt = Integer.parseInt(idade.get());
        if (idadeInt > 0 && idadeInt <12){
            return "Criança";
        }else if (idadeInt >= 12 && idadeInt <= 18){
            return "Adolescente";
       }else if (idadeInt >= 19 && idadeInt <= 60){
            return "Adulto";
       }if (idadeInt > 60){
          return "Idoso";
        } else {
            return "Idade inválida";
        }
    }


    @GetMapping("/get-num/{num}")
    public String verificaParImpar(@PathVariable Optional<String> num){
        num.ifPresent(value -> System.out.println("Numero: " + value));

        try{
        int numInt = Integer.parseInt(num.get());
        if (numInt % 2 == 0 && numInt > 0){
            return "Número é par";
        }else if (numInt % 2 != 0 && numInt > 0){
            return "Número é impar";
        }else if (numInt == 0){
            return "Número é 0";
        } else {
            return "Número inválido";
        }
    }catch(NumberFormatException e) {
        return "O valor não é um número, informe novamente";
    }
}

@GetMapping("/calc-imc/{peso}/{altura}")
    public String CalcIMC(@PathVariable String peso, @PathVariable String altura){
        try {
           
            double pesoDouble = Double.parseDouble(peso);
            double alturaDouble = Double.parseDouble(altura);
 
         
            if (pesoDouble <= 0 || alturaDouble <= 0) {
                return "Dados inválidos";
            }
           
            double imc = pesoDouble / (alturaDouble * alturaDouble);
           
            if (imc < 18.5) {
                return "Abaixo do peso";
            } else if (imc >= 18.5 && imc <= 24.9) {
                return "Peso normal";
            } else if (imc >= 25.0 && imc <= 29.9) {
                return "Sobrepeso";
            } else if (imc >= 30.0 && imc <= 34.9) {
                return "Obesidade grau 1";
            } else if (imc >= 35.0 && imc <= 39.9) {
                return "Obesidade grau 2";
            } else {
                return "Obesidade grau 3";
            }
        } catch (NumberFormatException e) {
            return "Dados inválidos";
        }
   
    }
}

