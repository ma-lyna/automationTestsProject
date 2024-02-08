package com.openfoodfacts.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllergModel {

    private Product product;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Product {
        @JsonProperty("knowledge_panels")
        private Panels knowledgePanels;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Panels {
        @JsonProperty("nutrient_level_sugars")
        private Sugars nutrientLevelSugars;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sugars {
        @JsonProperty("title_element")
        private Titlelement titleElement;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Titlelement {
        private String title;
    }
}
