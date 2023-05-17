package com.teun.model;

public class PokemonModel {

    private String pokemonName;
    private Long pokemonDexNumb;
    private Boolean legendary;


    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public Long getPokemonDexNumb() {
        return pokemonDexNumb;
    }

    public void setPokemonDexNumb(Long pokemonDexNumb) {
        this.pokemonDexNumb = pokemonDexNumb;
    }

    public Boolean getLegendary() {
        return legendary;
    }

    public void setLegendary(Boolean legendary) {
        this.legendary = legendary;
    }
}
