package com.openfoodfacts.specs;

import org.apache.commons.lang3.RandomStringUtils;

public class TestData {
        public static String randomPassword() {
                return RandomStringUtils.randomAlphanumeric(10);
        }
}
