package com.openfoodfacts.tests.api.cgipack;

import com.openfoodfacts.models.HtmlResponse;
import io.restassured.response.Response;

public class CgiBaseTest {
    protected HtmlResponse extractHtmlResponse(Response response) {
        String htmlBody = response.getBody().asString();
        return new HtmlResponse(htmlBody);
    }
}
