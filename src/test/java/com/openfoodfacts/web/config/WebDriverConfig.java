package com.openfoodfacts.web.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public class WebDriverConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://world.openfoodfacts.org/")
    String getBaseUrl();

    @Key("remoteUrl")
    String getRemote();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();
}