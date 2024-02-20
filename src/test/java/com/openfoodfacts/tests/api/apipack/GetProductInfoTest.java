package com.openfoodfacts.tests.api.apipack;

import com.openfoodfacts.models.ErrorResponseModel;
import com.openfoodfacts.models.GetProductNameModel;
import com.openfoodfacts.specs.ApiProductSpec;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetProductInfoTest extends ApiBaseTest {

    @Test
    @Tag("apiAuto")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("ma-lyna")
    @DisplayName("Get product name for a particular product id")
    void getProductNameShouldReturnCorrectValue() {
        GetProductNameModel response = step("Send request", () ->
                    given(ApiProductSpec.getProductNameRequestSpec)
                            .when()
                            .get(endpoint + productId)
                            .then()
                            .spec(ApiProductSpec.getProductNameResponseSpec)
                            .extract().as(GetProductNameModel.class));
        step("Check name", () ->
                    assertEquals(name, response.getProduct().getProductName()));
    }

    @Test
    @Tag("apiAuto")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("ma-lyna")
    @DisplayName("Information about product is not shown in case of invalid product id")
    void notGetProductName() {
        ErrorResponseModel response = step("Send request", () ->
                given(ApiProductSpec.getProductNameRequestSpec)
                        .when()
                        .get(endpoint + invalidProductId)
                        .then()
                        .spec(ApiProductSpec.getProductNameResponseSpec)
                        .extract().as(ErrorResponseModel.class));
        step("Check status", () ->
                assertEquals(0, response.getStatus()));
    }
}
