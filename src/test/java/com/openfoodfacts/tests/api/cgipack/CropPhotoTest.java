package com.openfoodfacts.tests.api.cgipack;

import com.openfoodfacts.models.CropPhotoResponseModel;
import com.openfoodfacts.specs.CgiProductSpec;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CropPhotoTest {
    @Test
    @Tag("apiAuto")
    @DisplayName("Photo is successfully cropped")
    void photoIsCroppedTest() {
        CropPhotoResponseModel response = step("Send request", () ->
                given(CgiProductSpec.cropPhotoRequestSpec)
                        .when()
                        .post("/product_image_crop.pl")
                        .then()
                        .spec(CgiProductSpec.cropPhotoResponseSpec)
                        .extract().as(CropPhotoResponseModel.class));
        step("Check imagefield", () ->
                assertEquals("front_en", response.getImagefield()));
    }
}
