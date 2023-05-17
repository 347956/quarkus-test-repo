package com.teun;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class PokemonControllerTest {

    @Test
    public void testGetAllPokemon(){

        given()
                .when().get("/api/pokemon/all")
                .then()
                .statusCode(200);
    }
}
