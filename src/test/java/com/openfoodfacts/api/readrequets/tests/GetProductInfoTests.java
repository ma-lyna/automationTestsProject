package com.openfoodfacts.api.readrequets.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetProductInfoTests extends TestBaseRead {

    @Test
    void getProductName() {
        given()
                .log().uri()
                .when()
                .get("v2/product/3017620422003")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("product.product_name", is("Nutella"));
    }
}
