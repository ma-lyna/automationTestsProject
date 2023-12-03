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
        private Panels knowledge_panels;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Panels {
        private Sugars nutrient_level_sugars;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sugars {
        private Titlelement title_element;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Titlelement {
        private String title;
    }
}
