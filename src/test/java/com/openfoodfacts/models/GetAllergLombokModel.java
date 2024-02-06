package com.openfoodfacts.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllergLombokModel {

    private Product product;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Product {
        private Panels knowledgePanels;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Panels {
        private Sugars nutrientLevelSugars;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sugars {
        private Titlelement titleElement;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Titlelement {
        private String title;
    }
}
