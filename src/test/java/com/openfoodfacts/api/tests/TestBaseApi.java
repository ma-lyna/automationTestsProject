package com.openfoodfacts.api.tests;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basePath;

public class TestBaseApi {
    @BeforeAll
    public static void baseURL() {
            baseURI = "https://world.openfoodfacts.net";
            basePath = "/api";
        }
}
