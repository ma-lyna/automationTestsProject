package com.openfoodfacts.tests.web;

import com.openfoodfacts.pages.AppPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AppTests extends TestBase {
    AppPage appPage = new AppPage();
    @Test
    @Tag("uiAuto")
    @Severity(SeverityLevel.NORMAL)
    @Owner("ma-lyna")
    @DisplayName("Observe QR code to download the app ")
    void checkQrExists() {
        step("Open the page to download mobile app", () -> {
            appPage.openAppPage();
        });
        step("Verify there is QR code to download mobile app", () -> {
            appPage.ObserveQr();
        });
    }
}
