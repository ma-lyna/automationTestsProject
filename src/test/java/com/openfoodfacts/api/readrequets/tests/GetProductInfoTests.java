package com.openfoodfacts.api.readrequets.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetProductInfoTests extends TestBaseRead {

    @Test
    void getProductName() {
        given()
                .log().uri()
                .when()
                .get("v2/product/3017620422003")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("product.product_name", is("Nutella"));
    }




    @Test
    void nTest() {


//        RestAssured.registerParser("image/png", Parser.JSON);






        given()
                //.queryParams("code", "2028", "name", "abcd")
                //     .queryParams("code", "3017620425035", "imgid", "2", "id", "front_en")
                .contentType("multipart/form-data")
                .multiPart("code", "3017620425035")
                .multiPart("user_id", "etamkis")
                .multiPart("password", "Testingproject")
                .log().uri()
                .log().method()
                .log().body()
                .when()
                .post("https://us.openfoodfacts.net/cgi/product_jqm2.pl")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
               .body("status", is(1));
    }



 //   public static void Registerparser (String text, Parser Parser);




    @Test
    void negative415Test() {


//        RestAssured.registerParser("image/png", Parser.JSON);






        given()
           //.queryParams("code", "2028", "name", "abcd")
              //     .queryParams("code", "3017620425035", "imgid", "2", "id", "front_en")
                .queryParam("code", "3017620425035")
                .queryParam("imgid", "imgid")
                .queryParam("id", "front_en")
                .log().uri()
                .log().method()
                .log().body()
                .when()
                .header("Content-Type", "text/x-perl")
                .post("https://world.openfoodfacts.net/cgi/product_image_crop.pl")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
       .body("imagefield", is("front_en"));
    }
}
