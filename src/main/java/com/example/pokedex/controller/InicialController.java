package com.example.pokedex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicialController {

    @GetMapping("/")
    public String inicio() {
        return "API Pokédex está funcionando";
    }
}
