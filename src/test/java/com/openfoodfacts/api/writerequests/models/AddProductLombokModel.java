package com.openfoodfacts.api.writerequests.models;

import lombok.Data;

@Data
public class AddProductLombokModel {

    String code;
    String user_id, password;
}

