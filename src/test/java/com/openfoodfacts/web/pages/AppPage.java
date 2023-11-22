package com.openfoodfacts.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AppPage {
    private SelenideElement
            qrCode = $("img[alt ='QR-Code linking to https://world.openfoodfacts.org/open-food-facts-mobile-app']");

    public AppPage openAppPage() {
        open("/open-food-facts-mobile-app/");

        return this;
    }

    public AppPage ObserveQr () {
        qrCode.should(exist);

        return this;
    }
}
