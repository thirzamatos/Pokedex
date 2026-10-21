package com.example.pokedex.service;

import com.example.pokedex.model.Pokemon;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PokemonService {

    private final Map<Long, Pokemon> pokemons = new LinkedHashMap<>();

    public PokemonService() {
        cadastroInicial();
    }

    private void cadastroInicial() {
        String[] nomes = {"Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard", "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill", "Pidgey", "Pidgeot", "Rattata", "Raticate", "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu", "Raichu", "Sandshrew", "Sandslash", "Nidoran", "Nidorina", "Nidoqueen", "Nidorino", "Nidoking", "Clefairy", "Clefable", "Vulpix", "Ninetales", "Jigglypuff", "Wigglytuff", "Zubat", "Golbat", "Oddish", "Gloom", "Vileplume", "Paras", "Parasect", "Venonat", "Venomoth", "Diglett", "Dugtrio"};

        String[] tipos = {"Planta", "Fogo", "Agua", "Inseto", "Voador", "Veneno", "Eletrico", "Normal", "Terra"};

        for(int i = 0; i < nomes.length; i++) {
            Long id = (long) (i + 1);
            String tipo = tipos[i % tipos.length];
            int nivel = 5 + (i % 20);

            Pokemon pokemon = new Pokemon(id, nomes[i], tipo, nivel);

            pokemons.put(id, pokemon);
        }
    }

    public Pokemon buscaPorId(Long id) {
        Pokemon pokemon = pokemons.get(id);

        if(pokemon == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pokémon não encontrado");
        }
        return pokemon;
    }

    public List<Pokemon> listarPokemons() {
        return new ArrayList<>(pokemons.values()).stream().limit(50).toList();
    }

    public Pokemon atualizar(Long id, Pokemon dadosAtualizados) {
        Pokemon pokemon = buscaPorId(id);

        pokemon.setNome(dadosAtualizados.getNome());
        pokemon.setTipo(dadosAtualizados.getTipo());
        pokemon.setNivel(dadosAtualizados.getNivel());

        return pokemon;
    }

    public void deletar(Long id) {
        buscaPorId(id);
        pokemons.remove(id);
    }
}
