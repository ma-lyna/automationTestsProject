package com.openfoodfacts.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NotGetAllergModel {
    private String code;
    private Integer status;
    @JsonProperty("status_verbose")
    private String statusVerbose;
}
