package com.openfoodfacts.api.tests.apipack;

import com.openfoodfacts.api.models.GetAllergLombokModel;
import com.openfoodfacts.api.models.NotGetAllergLombokModel;
import com.openfoodfacts.api.specs.ApiProductSpec;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.openfoodfacts.api.specs.ApiProductSpec.getAllergensRequestSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GetKnowledgePanelsTest {
    @Test
    @DisplayName("Get information about sugars for the particular product")
    void getAllergens() {
        GetAllergLombokModel response = step("Send request", () ->
                given(ApiProductSpec.getAllergensRequestSpec)
                        .when()
                        .get("v2/product/3017620422003")
                        .then()
                        .spec(ApiProductSpec.getAllergensResponseSpec)
                        .extract().as(GetAllergLombokModel.class));
        step("Check sugars in high quantity", () ->
                assertEquals("Sugars in high quantity (56.3%)", response.getProduct().getKnowledge_panels().getNutrient_level_sugars().getTitle_element().getTitle()));
    }

    @Test
    @DisplayName("Information about allergens is not shown in case of invalid product id")
    void notGetAllergens() {
        NotGetAllergLombokModel response = step("Send request", () ->
                given(getAllergensRequestSpec)
                        .when()
                        .get("v2/product/333")
                        .then()
                        .spec(ApiProductSpec.getAllergensResponseSpec)
                        .extract().as(NotGetAllergLombokModel.class));
        step("Check status", () ->
                assertEquals(0, response.getStatus()));
    }
}




