package com.openfoodfacts.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OpenFoodFactsPage {
    private SelenideElement
            searchInput = $(".columns input[name ='search_terms']"),
            searchBtn = $(".button.postfix"),
            searchResults = $(".row"),
            nutellaResult = $(".list_product_name.v-space-tiny"),
            searchResult = $("#preferences_switch_in_list_of_products_switch"),
            infoPage = $(byText("Poor match 31%"));
//            extSearchBtn = $(".supernova-navi-advanced-search-icon"),
//            extPageArea = $(".row-content form"),
//            createCvBtn = $(byText("Создать резюме")),
//            createCvPageArea = $(".signup-wrapper"),
//            logInBtn = $(byText("Войти")),
//            logInPageArea = $(".account-login-page");


    public OpenFoodFactsPage fillInSearch(String value) {
        searchInput.setValue(value);

        return this;
    }


    public OpenFoodFactsPage tapToSearch () {
        searchBtn.click();

        return this;
    }

    public OpenFoodFactsPage checkSearchResults () {
        searchResults.should(exist);

        return this;
    }

    public OpenFoodFactsPage checkNutellaResult() {
        nutellaResult.shouldHave(text("Nutella"));

        return this;
    }

    public OpenFoodFactsPage tapOnResult () {
        searchResult.click();

        return this;
    }
    public OpenFoodFactsPage verifyInfoPageExist () {
        infoPage.should(exist);

        return this;
    }
//
//    public OpenFoodFactsPage tapOnExtSearch () {
//        extSearchBtn.click();
//
//        return this;
//    }
//
//    public OpenFoodFactsPage checkPageExtSearch () {
//        extPageArea.should(exist);
//
//        return this;
//    }
//
//    public OpenFoodFactsPage tapOnCreateCv () {
//        createCvBtn.click();
//
//        return this;
//    }
//
//    public OpenFoodFactsPage checkPageCreateCv () {
//        createCvPageArea.should(exist);
//
//        return this;
//    }
//
//    public OpenFoodFactsPage tapOnLogIn () {
//        logInBtn.click();
//
//        return this;
//    }
//
//    public OpenFoodFactsPage checkPageLogIn () {
//        logInPageArea.should(exist);
//
//        return this;
//    }
}
