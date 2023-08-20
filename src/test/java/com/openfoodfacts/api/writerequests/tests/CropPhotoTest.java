package com.openfoodfacts.api.writerequests.tests;

import com.openfoodfacts.api.writerequests.models.CropPhotoResponseLombokModel;
import com.openfoodfacts.api.writerequests.specs.ProductSpecWrite;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CropPhotoTest extends TestBaseWrite {
    @Test
    void photoIsCroppedTest() {
        CropPhotoResponseLombokModel response = step("Send request", () ->
                given(ProductSpecWrite.cropPhotoRequestSpec)
                        .when()
                        .post("/product_image_crop.pl")
                        .then()
                        .spec(ProductSpecWrite.cropPhotoResponseSpec)
                        .extract().as(CropPhotoResponseLombokModel.class));
        step("Check imagefield", () ->
                assertEquals("front_en", response.getImagefield()));
        step("Check status", () ->
                assertEquals("status ok", response.getStatus()));
    }
}
