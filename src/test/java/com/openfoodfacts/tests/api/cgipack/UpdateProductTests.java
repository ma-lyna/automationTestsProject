package com.openfoodfacts.tests.api.cgipack;

import com.openfoodfacts.models.HtmlResponse;
import com.openfoodfacts.models.UpdateProductResponseModel;
import com.openfoodfacts.specs.CgiProductSpec;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UpdateProductTests extends CgiBaseTest {
    @Test
    @Tag("apiAuto")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("ma-lyna")
    @DisplayName("Successful product update")
    void successfulProductUpdate() {
        UpdateProductResponseModel response = step("Send request", () ->
                given(CgiProductSpec.updateProductRequestSpec)
                        .when()
                        .post("/product_jqm2.pl")
                        .then()
                        .spec(CgiProductSpec.updateProductResponseSpec)
                        .extract().as(UpdateProductResponseModel.class));
        step("Verify fields saved", () ->
                assertEquals("fields saved", response.getStatusVerbose()));
        step("Check status", () ->
                assertEquals(1, response.getStatus()));
    }

    @Test
    @Tag("apiAuto")
    @Severity(SeverityLevel.TRIVIAL)
    @Owner("ma-lyna")
    @DisplayName("Information update of unexisting product")
    void updateUnexistingProduct() {
        UpdateProductResponseModel response = step("Send request", () ->
                given(CgiProductSpec.updateInvalidProductRequestSpec)
                        .when()
                        .post("/product_jqm2.pl")
                        .then()
                        .spec(CgiProductSpec.updateInvalidProductResponseSpec)
                        .extract().as(UpdateProductResponseModel.class));
        step("Check response", () ->
                assertAll (
                        () -> assertEquals("no code or invalid code", response.getStatusVerbose()),
                        () -> assertEquals(0, response.getStatus()))
        );
    }

    @Test
    @Tag("apiAuto")
    @Severity(SeverityLevel.TRIVIAL)
    @Owner("ma-lyna")
    @DisplayName("Information update without authorization")
    void updateProductWithoutCreds() {
        UpdateProductResponseModel response = step("Send request", () ->
                given(CgiProductSpec.updateProductWithoutCredsRequestSpec)
                        .when()
                        .post("/product_jqm2.pl")
                        .then()
                        .spec(CgiProductSpec.updateProductWithoutCredsResponseSpec)
                        .extract().as(UpdateProductResponseModel.class));
        step("Verify fields saved", () ->
                assertEquals("fields saved", response.getStatusVerbose()));
        step("Check status", () ->
                assertEquals(1, response.getStatus()));
    }

    @Test
    @Tag("apiAuto")
    @Severity(SeverityLevel.TRIVIAL)
    @Owner("ma-lyna")
    @DisplayName("Information update with incorrect password")
    void upProduct() {
        Response response = given()
                .spec(CgiProductSpec.updateProductIncorrectPassRequestSpec)
                .when()
                .post("/product_jqm2.pl")
                .then()
                .spec(CgiProductSpec.updateProductIncorrectPassResponseSpec)
                .extract().response();
        HtmlResponse htmlResponse = extractHtmlResponse(response);
    }
}


