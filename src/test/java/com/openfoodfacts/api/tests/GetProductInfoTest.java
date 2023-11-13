package com.openfoodfacts.api.tests;

import com.openfoodfacts.api.models.GetProductNameLombokModel;
import org.junit.jupiter.api.Test;

import static com.openfoodfacts.api.specs.ProductSpec.getProductNameRequestSpec;
import static com.openfoodfacts.api.specs.ProductSpec.getProductNameResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetProductInfoTest extends TestBaseApi {
    @Test
    void getProductName() {
        GetProductNameLombokModel response = step("Send request", () ->
                    given(getProductNameRequestSpec)
                            .when()
                            .get("v2/product/3017620422003")
                            .then()
                            .spec(getProductNameResponseSpec)
                            .extract().as(GetProductNameLombokModel.class));
        step("Check name", () ->
                    assertEquals("Nutella", response.getProduct().getProduct_name()));
        }



//    @Test
//    void notGetProductName() {
//        given()
//                .log().uri()
//                .when()
//                .get("v2/product/3")
//                .then()
//                .log().status()
//                .log().body()
//                .statusCode(200);
//             //   .body("product.product_name", is("Nutella"));
//    }
}
