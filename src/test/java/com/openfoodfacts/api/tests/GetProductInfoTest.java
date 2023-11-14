package com.openfoodfacts.api.tests;

import com.openfoodfacts.api.models.GetProductNameLombokModel;
import com.openfoodfacts.api.models.NotGetProductNameLombokModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.openfoodfacts.api.specs.ProductSpec.getProductNameRequestSpec;
import static com.openfoodfacts.api.specs.ProductSpec.getProductNameResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetProductInfoTest extends TestBaseApi {
    @Test
    @DisplayName("Get product name for a particular product id")
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

    @Test
    @DisplayName("Information about product is not shown in case of invalid product id")
    void notGetProductName() {
        NotGetProductNameLombokModel response = step("Send request", () ->
                given(getProductNameRequestSpec)
                        .when()
                        .get("v2/product/333")
                        .then()
                        .spec(getProductNameResponseSpec)
                        .extract().as(NotGetProductNameLombokModel.class));
        step("Check status", () ->
                assertEquals(0, response.getStatus()));
    }
}
