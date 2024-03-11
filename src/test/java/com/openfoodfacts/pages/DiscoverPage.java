package com.openfoodfacts.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DiscoverPage {
    private SelenideElement
            searchFormLink = $(byText("search form")),
            productsSearchText = $(".small-12.column :nth-child(2)");

    public DiscoverPage openDiscoverPage() {
        open("https://world.openfoodfacts.org/discover/");

        return this;
    }

    public DiscoverPage observeSearchFormLink () {
        searchFormLink.should(exist);

        return this;
    }

    public DiscoverPage openProductsSearchPage () {
        productsSearchText.should(exist);

        return this;
    }
}
