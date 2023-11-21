package com.openfoodfacts.web.tests;

import com.openfoodfacts.web.pages.OpenFoodFactsPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class OpenFoodFactsTests extends TestBase {
    OpenFoodFactsPage openFoodFactsPage = new OpenFoodFactsPage();

    @Test
    @Tag("uiAuto")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("ma-lyna")
    @DisplayName("Displaying of 'Nutella' results after successful search")
    void checkSuccessfulSearch() {
        step("Fill in the 'Search' field with 'Nutella'", () -> {
            openFoodFactsPage.fillInSearch("Nutella");
        });
        step("Tap on the 'Search' button", () -> {
            openFoodFactsPage.tapToSearch();
        });
        step("Observe search results", () -> {
            openFoodFactsPage.checkSearchResults();
        });
        step("Verify the displayed result is 'Nutella' result", () -> {
            openFoodFactsPage.checkNutellaResult();
        });
    }

//    @Test
//    @Tag("uiAuto")
//    @Severity(SeverityLevel.BLOCKER)
//    @Owner("ma-lyna")
//    @DisplayName("Observe displaying of product info page")
//    void checkProductInfoPage() {
//        step("Fill in the 'Search' field with 'Nutella'", () -> {
//            openFoodFactsPage.fillInSearch("Nutella");
//        });
//        step("Tap on the 'Search' button", () -> {
//            openFoodFactsPage.tapToSearch();
//        });
//        step("Tap on any search result", () -> {
//            openFoodFactsPage.tapOnResult();
//        });
//        step("Verify the page with product info is displayed", () -> {
//            openFoodFactsPage.verifyInfoPageExist();
//        });
//    }

//    @Test
//    @Severity(SeverityLevel.CRITICAL)
//    @Owner("ma-lyna")
//    @DisplayName("Check the page with extended search is opened after tapping on 'Extended search'")
//    void checkJobsInSpecifiedCity() {
//        step("Tap on the 'Расширенный поиск' button'", () -> {
//            openFoodFacts.tapOnExtSearch();
//        });
//        step("Verify the page with extended search is opened", () -> {
//            openFoodFacts.checkPageExtSearch();
//        });
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Owner("ma-lyna")
//    @DisplayName("Check displaying of the page for creation a resume")
//    void checkCreationResume() {
//        step("Tap on the 'Создать резюме' button'", () -> {
//            openFoodFacts.tapOnCreateCv();
//        });
//        step("Verify the page for creation a resume is opened", () -> {
//            openFoodFacts.checkPageCreateCv();
//        });
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Owner("ma-lyna")
//    @DisplayName("Check displaying of the page for login")
//    void checkLogIn() {
//        step("Tap on the 'Войти' button'", () -> {
//            openFoodFacts.tapOnLogIn();
//        });
//        step("Verify login page is opened", () -> {
//            openFoodFacts.checkPageLogIn();
//        });
//    }
}
