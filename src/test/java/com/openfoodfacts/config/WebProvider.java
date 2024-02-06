package com.openfoodfacts.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;

public class WebProvider {
    static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
    public static void config () {
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser();
        Configuration.browserSize = config.browserSize();
        Configuration.browserVersion = config.browserVersion();
        Configuration.remote = config.remoteUrl();
    }
}