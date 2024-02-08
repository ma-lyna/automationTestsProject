package com.openfoodfacts.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetProductNameModel {
    private String code;
    private Integer status;
    @JsonProperty("status_verbose")
    private String statusVerbose;
    private Product product;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Product {
        @JsonProperty("product_name")
        private String productName;
    }
}
