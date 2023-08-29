package com.openfoodfacts.api.models;

import lombok.Data;

@Data
public class CropPhotoResponseLombokModel {
        private String imagefield, status;
     private Image image;

        @lombok.Data
        public static class Image {
                private String display_url;
        }
}

