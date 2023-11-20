package com.openfoodfacts.web.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Configuration.baseUrl;

public class WebDriverProvider {
    static config.WebDriverConfig config = ConfigFactory.create(config.WebDriverConfig.class, System.getProperties());

    public static void config() {
        baseUrl = WebDriverProvider.config.getBaseUrl();
        Configuration.browserSize = WebDriverProvider.config.getBrowserSize();
        Configuration.browser = WebDriverProvider.config.getBrowser().toString();
        Configuration.browserVersion = WebDriverProvider.config.getBrowserVersion();
        String remoteUrl = WebDriverProvider.config.getRemote();
        if (remoteUrl != null) {
            Configuration.remote = remoteUrl;
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
}
