package com.teun.controller;

import com.teun.model.PokemonModel;
import com.teun.service.PokemonService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api/pokemon")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PokemonController {

    @Inject
    PokemonService service;

    @GET
    @Path("/all")
    public List<PokemonModel> getAllPokemon(){
        return service.getAllPokemons();
    }
    @POST
    public List<PokemonModel> savePokemon(PokemonModel pokemonModel){
        service.savePokemon(pokemonModel);
        return getAllPokemon();
    }
}
