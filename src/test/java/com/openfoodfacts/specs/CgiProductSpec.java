package com.openfoodfacts.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.openfoodfacts.config.ApiConfig.*;
import static com.openfoodfacts.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class CgiProductSpec {
    public static RequestSpecification cropPhotoRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri(cgiBaseURI)
            .basePath(cgiBasePath)
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
    public static RequestSpecification addProductRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri(cgiBaseURI)
            .basePath(cgiBasePath)
            .contentType("multipart/form-data")
            .multiPart("code", "4810128003311")
            .multiPart("user_id", "etamki")
            .multiPart("password", "Testproject")
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
            .baseUri(cgiBaseURI)
            .basePath(cgiBasePath)
            .contentType("multipart/form-data")
            .multiPart("code", "")
            .multiPart("user_id", "etamki")
            .multiPart("password", "Testproject")
            .log().uri()
            .log().method()
            .log().body();

    public static ResponseSpecification notAddProductResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .build();
}
