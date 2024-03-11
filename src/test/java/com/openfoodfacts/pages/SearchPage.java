package com.openfoodfacts.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage {
    private SelenideElement
            searchInput = $(".columns input[name ='search_terms']"),
            searchBtn = $(".button.postfix"),
            searchResults = $(".row"),
            nutellaResult = $(".list_product_name"),
            searchResult = $("#preferences_switch_in_list_of_products_switch"),
            infoPage = $(byText("Poor match 31%"));

    public SearchPage openSearchPage() {
        open("https://world.openfoodfacts.org");

        return this;
    }

    public SearchPage fillInSearch(String value) {
        searchInput.setValue(value);

        return this;
    }


    public SearchPage tapToSearch () {
        searchBtn.click();

        return this;
    }

    public SearchPage checkSearchResults () {
        searchResults.should(exist);

        return this;
    }

    public SearchPage checkProductResult(String product) {
        nutellaResult.shouldHave(text(product));

        return this;
    }

    public SearchPage tapToClassify () {
        searchResult.click();

        return this;
    }
    public SearchPage observePoorMatch () {
        infoPage.should(exist);

        return this;
    }
}
