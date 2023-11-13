package com.openfoodfacts.api.tests;

import com.openfoodfacts.api.models.GetAllergLombokModel;
import com.openfoodfacts.api.models.NotGetAllergLombokModel;
import org.junit.jupiter.api.Test;

import static com.openfoodfacts.api.specs.ProductSpec.getAllergensRequestSpec;
import static com.openfoodfacts.api.specs.ProductSpec.getAllergensResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GetKnowledgePanelsTest extends TestBaseApi {
    @Test
    void getAllergens() {
        GetAllergLombokModel response = step("Send request", () ->
                given(getAllergensRequestSpec)
                        .when()
                        .get("v2/product/3017620422003")
                        .then()
                        .spec(getAllergensResponseSpec)
                        .extract().as(GetAllergLombokModel.class));
        step("Check sugars in high quantity", () ->
                assertEquals("Sugars in high quantity (56.3%)", response.getProduct().getKnowledge_panels().getNutrient_level_sugars().getTitle_element().getTitle()));
    }

    @Test
    void notGetAllergens() {
        NotGetAllergLombokModel response = step("Send request", () ->
                given(getAllergensRequestSpec)
                        .when()
                        .get("v2/product/333")
                        .then()
                        .spec(getAllergensResponseSpec)
                        .extract().as(NotGetAllergLombokModel.class));
        step("Check status", () ->
                assertEquals(0, response.getStatus()));
    }
}




