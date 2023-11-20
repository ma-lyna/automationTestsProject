package com.openfoodfacts.web.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tags({@Tag("UI")})

public class OpenFoodFacts extends TestBase {
    OpenFoodFacts openFoodFacts = new OpenFoodFacts();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Owner("ma-lyna")
    @DisplayName("Displaying of 'Nutella' results after successful search")
    void checkSuccessfulSearch() {
        step("Fill in the 'Search' field with 'Nutella'", () -> {
            openFoodFacts.fillSearchField("Nutella");
        });
//        step("Tap on the 'Search' button", () -> {
//            openFoodFacts.tapToSearch();
//        });
//        step("Check displaying of results after search", () -> {
//            openFoodFacts.checkSearchResults();
//        });
//        step("Verify the displayed result is 'Nutella' result", () -> {
//            openFoodFacts.checkQaResult();
//        });
    }

//    @Test
//    @Severity(SeverityLevel.CRITICAL)
//    @Owner("ma-lyna")
//    @DisplayName("Check filter by experience from 1 to 3 years")
//    void checkJobsWithOneAndThreeExp() {
//        step("Fill in the 'Search' field with 'QA'", () -> {
//            openFoodFacts.fillInSearchField("QA");
//        });
//        step("Tap on the 'Найти работу' button'", () -> {
//            openFoodFacts.tapToSearch();
//        });
//        step("Choose the filter 'from 1 to 3 years of experience' ", () -> {
//            openFoodFacts.checkSpecifiedExp();
//        });
//        step("Verify the positions with experience from 1 to 3 years are displayed", () -> {
//            openFoodFacts.verifySpecifiedExpExist();
//        });
//    }
//
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
