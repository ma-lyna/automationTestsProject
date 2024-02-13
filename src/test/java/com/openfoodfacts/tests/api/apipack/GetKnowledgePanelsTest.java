package com.openfoodfacts.tests.api.apipack;

import com.openfoodfacts.models.ErrorResponseModel;
import com.openfoodfacts.models.GetAllergModel;
import com.openfoodfacts.specs.ApiProductSpec;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.openfoodfacts.specs.ApiProductSpec.getAllergensRequestSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GetKnowledgePanelsTest extends ApiBaseTest {

    @Test
    @Tag("apiAuto")
    @Severity(SeverityLevel.NORMAL)
    @Owner("ma-lyna")
    @DisplayName("Get information about sugars for the particular product")
    void getAllergens() {
        GetAllergModel response = step("Send request", () ->
                given(ApiProductSpec.getAllergensRequestSpec)
                        .when()
                        .get(endpoint + productId)
                        .then()
                        .spec(ApiProductSpec.getAllergensResponseSpec)
                        .extract().as(GetAllergModel.class));
        step("Check sugars in high quantity", () ->
                assertEquals("Sugars in high quantity (56.3%)", response.getProduct().getKnowledgePanels().getNutrientLevelSugars().getTitleElement().getTitle()));
    }

    @Test
    @Tag("apiAuto")
    @Severity(SeverityLevel.TRIVIAL)
    @Owner("ma-lyna")
    @DisplayName("Error behaviour if if asking for allergens of invalid product id")
    void notGetAllergens() {
        ErrorResponseModel response = step("Send request", () ->
                given(getAllergensRequestSpec)
                        .when()
                        .get(endpoint + invalidProductId)
                        .then()
                        .spec(ApiProductSpec.getAllergensResponseSpec)
                        .extract().as(ErrorResponseModel.class));
        step("Check response", () ->
                assertAll (
                         () -> assertEquals("no code or invalid code", response.getStatusVerbose()),
                         () -> assertEquals(0, response.getStatus()))
        );
    }
}

//helllo


