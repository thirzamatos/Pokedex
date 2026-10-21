package com.example.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pokemon {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String nome;
    private String tipo;
    private int nivel;

    public Pokemon( ) { }

    public Pokemon(Long id, String nome, String tipo, int nivel) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

}
