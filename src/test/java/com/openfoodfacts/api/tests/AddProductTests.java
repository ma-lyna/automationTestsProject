package com.openfoodfacts.api.tests;

import com.openfoodfacts.api.models.AddProductResponseLombokModel;
import com.openfoodfacts.api.specs.ProductSpec;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AddProductTests extends TestBaseCgi {
    @Test
    void newProductAddedTest() {
        AddProductResponseLombokModel response = step("Send request", () ->
                given(ProductSpec.addProductRequestSpec)
                        .when()
                        .post("/product_jqm2.pl")
                        .then()
                        .spec(ProductSpec.addProductResponseSpec)
                        .extract().as(AddProductResponseLombokModel.class));
        step("Verify fields saved", () ->
                assertEquals("fields saved", response.getStatus_verbose()));
        step("Check status", () ->
             assertEquals(1, response.getStatus()));
   }

    @Test
    void newProductNotAddedTest() {
        AddProductResponseLombokModel response = step("Send request", () ->
                given(ProductSpec.notAddProductRequestSpec)
                        .when()
                        .post("/product_jqm2.pl")
                        .then()
                        .spec(ProductSpec.notAddProductResponseSpec)
                        .extract().as(AddProductResponseLombokModel.class));
        step("Check status", () ->
                assertEquals(0, response.getStatus()));
    }
}


