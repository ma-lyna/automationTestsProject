package com.openfoodfacts.specs;

import com.openfoodfacts.config.ApiConfig;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;

import static com.openfoodfacts.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class ApiProductSpec {
    private static ApiConfig config = ConfigFactory.create(ApiConfig.class);
    public static RequestSpecification getAllergensRequestSpec = with()

            .filter(withCustomTemplates())
            .baseUri(config.baseURI())
            .basePath(config.apiBasePath())
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
            .baseUri(config.baseURI())
            .basePath(config.apiBasePath())
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
