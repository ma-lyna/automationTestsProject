package com.openfoodfacts.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.openfoodfacts.api.configuration.ApiConfig.apiBasePath;
import static com.openfoodfacts.api.configuration.ApiConfig.apiBaseURI;
import static com.openfoodfacts.api.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class ApiProductSpec {
    public static RequestSpecification getAllergensRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri(apiBaseURI)
            .basePath(apiBasePath)
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
            .baseUri(apiBaseURI)
            .basePath(apiBasePath)
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
