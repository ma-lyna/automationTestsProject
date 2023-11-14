package com.openfoodfacts.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.openfoodfacts.api.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.parsing.Parser.JSON;

public class ProductSpec {
    public static RequestSpecification addProductRequestSpec = with()
            .filter(withCustomTemplates())
            .contentType("multipart/form-data")
            .multiPart("code", "4810128003311")
            .multiPart("user_id", "etamkis")
            .multiPart("password", "Testingproject")
            .log().uri()
            .log().method()
            .log().body();

    public static ResponseSpecification addProductResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();

    public static RequestSpecification notAddProductRequestSpec = with()
            .filter(withCustomTemplates())
            .contentType("multipart/form-data")
            .multiPart("code", "")
            .multiPart("user_id", "etamkis")
            .multiPart("password", "Testingproject")
            .log().uri()
            .log().method()
            .log().body();

    public static ResponseSpecification notAddProductResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .build();

    public static RequestSpecification cropPhotoRequestSpec = with()
            .filter(withCustomTemplates())
            .contentType("multipart/form-data")
            .multiPart("code", "04963406")
            .multiPart("imgid", "2")
            .multiPart("id", "front_en")
            .log().uri()
            .log().method()
            .log().body();

    public static ResponseSpecification cropPhotoResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();

    public static RequestSpecification getAllergensRequestSpec = with()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON)
            .queryParam("fields", "knowledge_panels")
            .log().uri()
            .log().method()
            .log().body();

    public static ResponseSpecification getAllergensResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();

    public static RequestSpecification getProductNameRequestSpec = with()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON)
            .log().uri()
            .log().method()
            .log().body();

    public static ResponseSpecification getProductNameResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();
}
