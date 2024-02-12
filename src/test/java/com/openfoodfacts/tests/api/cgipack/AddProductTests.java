package com.openfoodfacts.tests.api.cgipack;

import com.openfoodfacts.models.AddProductResponseModel;
import com.openfoodfacts.specs.CgiProductSpec;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AddProductTests {
    @Test
    @Tag("apiAuto")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("ma-lyna")
    @DisplayName("A new product is successfully added")
    void newProductAddedTest() {
        AddProductResponseModel response = step("Send request", () ->
                given(CgiProductSpec.addProductRequestSpec)
                        .when()
                        .post("/product_jqm2.pl")
                        .then()
                        .spec(CgiProductSpec.addProductResponseSpec)
                        .extract().as(AddProductResponseModel.class));
        step("Verify fields saved", () ->
                assertEquals("fields saved", response.getStatusVerbose()));
        step("Check status", () ->
             assertEquals(1, response.getStatus()));
   }

    @Test
    @Tag("apiAuto")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("ma-lyna")
    @DisplayName("A new product is not added")
    void newProductNotAddedTest() {
        AddProductResponseModel response = step("Send request", () ->
                given(CgiProductSpec.notAddProductRequestSpec)
                        .when()
                        .post("/product_jqm2.pl")
                        .then()
                        .spec(CgiProductSpec.notAddProductResponseSpec)
                        .extract().as(AddProductResponseModel.class));
        step("Check status", () ->
                assertEquals(0, response.getStatus()));
    }
}


