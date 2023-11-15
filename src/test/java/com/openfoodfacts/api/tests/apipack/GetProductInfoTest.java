package com.openfoodfacts.api.tests.apipack;

import com.openfoodfacts.api.models.GetProductNameLombokModel;
import com.openfoodfacts.api.models.NotGetProductNameLombokModel;
import com.openfoodfacts.api.specs.ApiProductSpec;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetProductInfoTest {
    @Test
    @DisplayName("Get product name for a particular product id")
    void getProductName() {
        GetProductNameLombokModel response = step("Send request", () ->
                    given(ApiProductSpec.getProductNameRequestSpec)
                            .when()
                            .get("v2/product/3017620422003")
                            .then()
                            .spec(ApiProductSpec.getProductNameResponseSpec)
                            .extract().as(GetProductNameLombokModel.class));
        step("Check name", () ->
                    assertEquals("Nutella", response.getProduct().getProduct_name()));
    }

    @Test
    @DisplayName("Information about product is not shown in case of invalid product id")
    void notGetProductName() {
        NotGetProductNameLombokModel response = step("Send request", () ->
                given(ApiProductSpec.getProductNameRequestSpec)
                        .when()
                        .get("v2/product/333")
                        .then()
                        .spec(ApiProductSpec.getProductNameResponseSpec)
                        .extract().as(NotGetProductNameLombokModel.class));
        step("Check status", () ->
                assertEquals(0, response.getStatus()));
    }
}
