package com.openfoodfacts.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface WebConfig extends Config {
        @Key("baseUrl")
        @DefaultValue("https://world.openfoodfacts.org")
        String baseUrl();

        @Key("browser")
        @DefaultValue("CHROME")
        String browser();

        @Key("browserSize")
        @DefaultValue("2560x1440")
        String browserSize();

        @Key("browserVersion")
        @DefaultValue("100.0")
        String browserVersion();

        @Key("remoteUrl")
        @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
        String remoteUrl();
}
