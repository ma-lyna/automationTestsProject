package com.openfoodfacts.api.readrequets.tests;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basePath;

public class TestBaseRead {
    @BeforeAll
    public static void baseURL() {
            baseURI = "https://world.openfoodfacts.net";
            basePath = "/api";
        }
}
