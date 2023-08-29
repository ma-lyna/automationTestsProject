package com.openfoodfacts.api.tests;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.*;

public class TestBaseCgi {
        @BeforeAll
        public static void baseURL() {
            baseURI = "https://world.openfoodfacts.net";
            basePath = "/cgi";
            registerParser("text/plain", Parser.JSON);
        }
}

