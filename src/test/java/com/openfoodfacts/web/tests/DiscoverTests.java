package com.openfoodfacts.web.tests;

import com.openfoodfacts.web.pages.ContributePage;
import com.openfoodfacts.web.pages.DiscoverPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class DiscoverTests extends TestBase {
    DiscoverPage discoverPage = new DiscoverPage();
    @Test
    @Tag("uiAuto")
    @Severity(SeverityLevel.NORMAL)
    @Owner("ma-lyna")
    @DisplayName("Observe search form link on the 'Discover' page")
    void checksearchFormLink() {
        step("Open the 'Discover' page", () -> {
            discoverPage.openDiscoverPage();
        });
        step("Verify there is search form link on the 'Discover' page", () -> {
            discoverPage.observeSearchFormLink();
        });
        step("Verify the 'Products search' page is opened after tapping on 'search form' link", () -> {
            discoverPage.openProductsSearchPage();
        });
    }
}
