package com.openfoodfacts.tests.api.apipack;

import com.openfoodfacts.models.GetProductNameLombokModel;
import com.openfoodfacts.models.NotGetProductNameLombokModel;
import com.openfoodfacts.specs.ApiProductSpec;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetProductInfoTest {
    @Test
    @Tag("apiAuto")
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
                    assertEquals("Nutella", response.getProduct().getProductName()));
    }

    @Test
    @Tag("apiAuto")
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
