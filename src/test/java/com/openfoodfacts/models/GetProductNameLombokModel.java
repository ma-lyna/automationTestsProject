package com.openfoodfacts.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class GetProductNameLombokModel {
    String code;
    Integer status;
    String statusVerbose;
    private Product product;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Product {
        private String productName;
    }
}
