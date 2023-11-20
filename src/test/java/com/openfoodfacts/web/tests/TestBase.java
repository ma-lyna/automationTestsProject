package com.openfoodfacts.web.tests;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
//    @BeforeAll
//    static void setUp() {
//        WebDriverProvider.config();
//    }

    @BeforeEach
    void addListener() {
     //   SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open("https://world.openfoodfacts.org");
    }

//    @AfterEach
//    void addAttachments(){
//        Attach.screenshotAs("Last screenshot");
//        Attach.pageSource();
//        Attach.browserConsoleLogs();
//        Attach.addVideo();
//    }
}
