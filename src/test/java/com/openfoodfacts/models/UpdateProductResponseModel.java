package com.openfoodfacts.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UpdateProductResponseModel {
        private Integer status;
        @JsonProperty("status_verbose")
        private String statusVerbose;
}

