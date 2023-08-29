package com.openfoodfacts.api.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetKnowledgePanelsTest extends TestBaseApi {
    @Test
    void getAllergens() {
        given()
                .log().uri()
                .when()
                .get("v2/product/3017620422003?fields=knowledge_panels")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("product.knowledge_panels.nutrient_level_sugars.title_element.title", is("Sugars in high quantity (56.3%)"));
    }

    @Test
    void notgetAllergens() {
        given()
                .log().uri()
                .when()
                .get("v2/product/3?fields=knowledge_panels")
                .then()
                .log().status()
                .log().body();
           //     .statusCode(200)
           //     .body("product.knowledge_panels.nutrient_level_sugars.title_element.title", is("Sugars in high quantity (56.3%)"));
    }
}
