package com.openfoodfacts.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CropPhotoResponseLombokModel {
    private String imagefield, status;
    private Image image;
    @lombok.Data
    public static class Image {
        @JsonProperty("display_url")
        private String display_url;
    }
}

