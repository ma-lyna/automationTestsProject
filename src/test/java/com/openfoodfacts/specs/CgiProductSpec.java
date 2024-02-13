package com.openfoodfacts.specs;

import com.openfoodfacts.config.ApiConfig;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;

import static com.openfoodfacts.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class CgiProductSpec {
    private static ApiConfig config = ConfigFactory.create(ApiConfig.class);
    public static RequestSpecification addProductRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri(config.baseURI())
            .basePath(config.cgiBasePath())
            .contentType("multipart/form-data")
            .multiPart("code", "4810128003311")
            .multiPart("user_id", config.userId())
            .multiPart("password",config.password())
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
            .baseUri(config.baseURI())
            .basePath(config.cgiBasePath())
            .contentType("multipart/form-data")
            .multiPart("code", "")
            .multiPart("user_id", config.userId())
            .multiPart("password",config.password())
            .log().uri()
            .log().method()
            .log().body();

    public static ResponseSpecification notAddProductResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .build();

    public static RequestSpecification updateProductRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri(config.baseURI())
            .basePath(config.cgiBasePath())
            .contentType("multipart/form-data")
            .multiPart("code", config.productCode())
            .multiPart("user_id", config.userId())
            .multiPart("password",config.password())
            .multiPart("categories",config.category())
            .log().uri()
            .log().method()
            .log().body();
    public static ResponseSpecification updateProductResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();
}
