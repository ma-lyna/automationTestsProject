package com.openfoodfacts.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class OpenFoodFactsPage {
    private SelenideElement
            searchInput = $(".columns input[name ='search_terms']"),
            searchBtn = $(".button.postfix"),
            searchResults = $(".row"),
            qaResult = $(".list_product_name.v-space-tiny");
//            specifiedExpRb = $(".nova-control--GtG8Kpo7kAMGijnRbxtY:nth-child(7) .bloko-form-item"),
//            specifiedExp = $(".vacancy-serp-item__layout span[data-qa ='vacancy-serp__vacancy-compensation']"),
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

    public OpenFoodFactsPage checkQaResult () {
        qaResult.shouldHave(text("Nutella"));

        return this;
    }
//
//    public OpenFoodFactsPage checkSpecifiedExp () {
//        specifiedExpRb.scrollTo().click();
//
//        return this;
//    }
//    public OpenFoodFactsPage verifySpecifiedExpExist () {
//        specifiedExp.should(exist);
//
//        return this;
//    }
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
