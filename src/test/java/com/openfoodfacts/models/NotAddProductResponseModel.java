package com.openfoodfacts.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NotAddProductResponseModel {
        private Integer status;
        @JsonProperty("status_verbose")
        private String statusVerbose;
}

