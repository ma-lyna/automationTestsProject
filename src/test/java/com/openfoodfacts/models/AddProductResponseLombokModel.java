package com.openfoodfacts.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddProductResponseLombokModel {
        Integer status;
        @JsonProperty("status_verbose")
        String statusVerbose;
}

