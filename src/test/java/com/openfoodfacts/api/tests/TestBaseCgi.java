package com.openfoodfacts.api.tests;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class TestBaseCgi {
        @BeforeAll
        public static void baseURL() {
            baseURI = "https://world.openfoodfacts.net";
            basePath = "/cgi";
        }
}

