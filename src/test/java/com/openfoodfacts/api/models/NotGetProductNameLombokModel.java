package com.openfoodfacts.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class NotGetProductNameLombokModel {
    String code;
    Integer status;
    String status_verbose;
}
