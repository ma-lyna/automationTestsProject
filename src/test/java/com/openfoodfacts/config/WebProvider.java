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



















//    public static void config() {









//        baseUrl = WebDriverProvider.config.getBaseUrl();
//        Configuration.browserSize = WebDriverProvider.config.getBrowserSize();
//        Configuration.browser = WebDriverProvider.config.getBrowser().toString();
//        Configuration.browserVersion = WebDriverProvider.config.getBrowserVersion();
//        String remoteUrl = WebDriverProvider.config.getRemote();
//        if (remoteUrl != null) {
//            Configuration.remote = remoteUrl;
//        }
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
////        capabilities.setCapability("enableVNC", true);
////        capabilities.setCapability("enableVideo", true);
//        Configuration.browserCapabilities = capabilities;
//    }

