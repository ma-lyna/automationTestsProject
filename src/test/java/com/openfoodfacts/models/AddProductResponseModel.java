package com.openfoodfacts.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddProductResponseModel {
        private Integer status;
        @JsonProperty("status_verbose")
        private String statusVerbose;
}

