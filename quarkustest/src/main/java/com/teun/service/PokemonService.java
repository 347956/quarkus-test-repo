package com.teun.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.teun.model.PokemonModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PokemonService {

    @Inject
    MongoClient mongoClient;

    public List<PokemonModel> getAllPokemons(){
        List<PokemonModel> foundPokemons = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();
        try{
            while (cursor.hasNext()){
                Document document = cursor.next();
                PokemonModel foundPokemonModel = new PokemonModel();
                foundPokemonModel.setPokemonName(document.getString("pokemonName"));
                foundPokemonModel.setPokemonDexNumb(document.getLong("pokemonDexNumb"));
                foundPokemonModel.setLegendary(document.getBoolean("legendary"));
                foundPokemons.add(foundPokemonModel);
            }
        }
        finally {
            cursor.close();
        }
        return foundPokemons;
    }

    public void savePokemon(PokemonModel pokemonModel){
        Document document = new Document()
                .append("pokemonName", pokemonModel.getPokemonName())
                .append("pokemonDexNumb", pokemonModel.getPokemonDexNumb())
                .append("legendary", pokemonModel.getLegendary());
        getCollection().insertOne(document);
    }

    private MongoCollection getCollection(){
        return mongoClient.getDatabase("pokemon").getCollection("pokemons");
    }
}
