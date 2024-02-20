package com.openfoodfacts.models;

import lombok.Data;

@Data
public class HtmlResponse {
    private String htmlBody;

    public HtmlResponse(String htmlBody) {
        this.htmlBody = htmlBody;
    }
}