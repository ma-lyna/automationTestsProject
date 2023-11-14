package com.openfoodfacts.api.tests;

import com.openfoodfacts.api.models.CropPhotoResponseLombokModel;
import com.openfoodfacts.api.specs.ProductSpec;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CropPhotoTest extends TestBaseCgi {
    @Test
    @DisplayName("Photo is successfully cropped")
    void photoIsCroppedTest() {
        CropPhotoResponseLombokModel response = step("Send request", () ->
                given(ProductSpec.cropPhotoRequestSpec)
                        .when()
                        .post("/product_image_crop.pl")
                        .then()
                        .spec(ProductSpec.cropPhotoResponseSpec)
                        .extract().as(CropPhotoResponseLombokModel.class));
        step("Check imagefield", () ->
                assertEquals("front_en", response.getImagefield()));
    }
}
