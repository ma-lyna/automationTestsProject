package com.openfoodfacts.api.writerequests.tests;

import com.openfoodfacts.api.writerequests.specs.ProductSpecWrite;
import com.openfoodfacts.api.writerequests.models.AddProductResponseLombokModel;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AddProductTest extends TestBaseWrite {
    @Test
    void newProductAddedTest() {
        AddProductResponseLombokModel response = step("Send request", () ->
                given(ProductSpecWrite.addProductRequestSpec)
                        .when()
                        .post("/product_jqm2.pl")
                        .then()
                        .spec(ProductSpecWrite.addProductResponseSpec)
                        .extract().as(AddProductResponseLombokModel.class));
        step("Verify fields saved", () ->
                assertEquals("fields saved", response.getStatus_verbose()));
        step("Check status", () ->
             assertEquals(1, response.getStatus()));
   }
}


