package com.openfoodfacts.tests.api.apipack;

import com.openfoodfacts.models.ErrorResponseModel;
import com.openfoodfacts.models.GetAllergModel;
import com.openfoodfacts.specs.ApiProductSpec;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.openfoodfacts.specs.ApiProductSpec.getAllergensRequestSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GetKnowledgePanelsTest {
    @Test
    @Tag("apiAuto")
    @DisplayName("Get information about sugars for the particular product")
    void getAllergens() {
        GetAllergModel response = step("Send request", () ->
                given(ApiProductSpec.getAllergensRequestSpec)
                        .when()
                        .get("v2/product/3017620422003")
                        .then()
                        .spec(ApiProductSpec.getAllergensResponseSpec)
                        .extract().as(GetAllergModel.class));
        step("Check sugars in high quantity", () ->
                assertEquals("Sugars in high quantity (56.3%)", response.getProduct().getKnowledgePanels().getNutrientLevelSugars().getTitleElement().getTitle()));
    }

    @Test
    @Tag("apiAuto")
    @DisplayName("Information about allergens is not shown in case of invalid product id")
    void notGetAllergens() {
        ErrorResponseModel response = step("Send request", () ->
                given(getAllergensRequestSpec)
                        .when()
                        .get("v2/product/333")
                        .then()
                        .spec(ApiProductSpec.getAllergensResponseSpec)
                        .extract().as(ErrorResponseModel.class));
        step("Check status", () ->
                assertEquals(0, response.getStatus()));
    }
}




