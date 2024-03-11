package com.openfoodfacts.tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.openfoodfacts.config.WebProvider;
import com.openfoodfacts.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        WebProvider.config();
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, Object> value = new HashMap<>();
        value.put("enableVNC", true);
        value.put("enableVideo", true);
        capabilities.setCapability("selenoid:options", value);

        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
    void afterEach() {
        Attach.screenShotAs("Last screenshot");
        Attach.pageSource();
        String browserProperty = System.getProperty("browser");
        if (browserProperty != null && !browserProperty.equalsIgnoreCase("Mozilla")) {
            Attach.browserConsoleLog();
        }
        Attach.addVideo();

        Selenide.closeWebDriver();
    }
}
