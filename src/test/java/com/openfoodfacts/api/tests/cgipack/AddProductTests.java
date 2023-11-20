package com.openfoodfacts.api.tests.cgipack;

import com.openfoodfacts.api.models.AddProductResponseLombokModel;
import com.openfoodfacts.api.specs.CgiProductSpec;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AddProductTests {
    @Test
    @Tag("apiAuto")
    @DisplayName("A new product is successfully added")
    void newProductAddedTest() {
        AddProductResponseLombokModel response = step("Send request", () ->
                given(CgiProductSpec.addProductRequestSpec)
                        .when()
                        .post("/product_jqm2.pl")
                        .then()
                        .spec(CgiProductSpec.addProductResponseSpec)
                        .extract().as(AddProductResponseLombokModel.class));
        step("Verify fields saved", () ->
                assertEquals("fields saved", response.getStatus_verbose()));
        step("Check status", () ->
             assertEquals(1, response.getStatus()));
   }



    @Test
    @Tag("apiAuto")
    @DisplayName("A new product is not added")
    void newProductNotAddedTest() {
        AddProductResponseLombokModel response = step("Send request", () ->
                given(CgiProductSpec.notAddProductRequestSpec)
                        .when()
                        .post("/product_jqm2.pl")
                        .then()
                        .spec(CgiProductSpec.notAddProductResponseSpec)
                        .extract().as(AddProductResponseLombokModel.class));
        step("Check status", () ->
                assertEquals(0, response.getStatus()));
    }
}


