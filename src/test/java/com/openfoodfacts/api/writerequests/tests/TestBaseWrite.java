package com.openfoodfacts.api.writerequests.tests;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basePath;

public class TestBaseWrite {
        @BeforeAll
        public static void baseURL() {
            baseURI = "https://world.openfoodfacts.net";
            basePath = "/cgi";
        }
}

