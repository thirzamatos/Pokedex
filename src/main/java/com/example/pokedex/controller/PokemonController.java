package com.example.pokedex.controller;

import com.example.pokedex.model.Pokemon;
import com.example.pokedex.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> buscaPorId(@PathVariable Long id) {
        Pokemon pokemon = pokemonService.buscaPorId(id);

        return ResponseEntity.ok(pokemon);
    }

    @GetMapping
    public ResponseEntity<List<Pokemon>> listarPokemons() {
        List<Pokemon> pokemons = pokemonService.listarPokemons();

        return ResponseEntity.ok(pokemons);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pokemon> atualizar(
            @PathVariable Long id,
            @RequestBody Pokemon dadosAtualizados
    ) {
        Pokemon pokemonAtualizado = pokemonService.atualizar(id, dadosAtualizados);

        return ResponseEntity.ok(pokemonAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pokemonService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
