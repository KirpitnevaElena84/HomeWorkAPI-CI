package ru.netology.rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class AccountsSchemaTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost:9999";
    }

    @Test
    void accountsResponseShouldMatchSchema() {
        RestAssured
                .given()
                .when()
                .get("/api/v1/demo/accounts")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }
}
