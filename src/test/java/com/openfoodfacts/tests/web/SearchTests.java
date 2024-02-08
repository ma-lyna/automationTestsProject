package com.openfoodfacts.tests.web;

import com.openfoodfacts.pages.SearchPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {
    SearchPage searchPage = new SearchPage();

    @Test
    @Tag("uiAuto")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("ma-lyna")
    @DisplayName("Displaying of 'Nutella' results after successful search")
    void checkSuccessfulSearch() {
        step("Fill in the 'Search' field with 'Nutella'", () -> {
            searchPage.fillInSearch("Nutella");
        });
        step("Tap on the 'Search' button", () -> {
            searchPage.tapToSearch();
        });
        step("Observe search results", () -> {
            searchPage.checkSearchResults();
        });
        step("Verify the displayed result is 'Nutella' result", () -> {
            searchPage.checkProductResult("Nutella");
        });
    }

    @Test
    @Tag("uiAuto")
    @Severity(SeverityLevel.NORMAL)
    @Owner("ma-lyna")
    @DisplayName("Observe displaying of the banner 'Poor match 31%'")
    void checkProductBanner() {
        step("Fill in the 'Search' field with 'Nutella'", () -> {
            searchPage.fillInSearch("Nutella");
        });
        step("Tap on the 'Search' button", () -> {
            searchPage.tapToSearch();
        });
        step("Tap to classify 24 products below according to your preferences", () -> {
            searchPage.tapToClassify();
        });
        step("Observe the banner 'Poor match 31%'", () -> {
            searchPage.observePoorMatch();
        });
    }
}
