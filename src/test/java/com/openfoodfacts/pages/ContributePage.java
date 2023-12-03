package com.openfoodfacts.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ContributePage {
    private SelenideElement
            btnSkillForm = $(byText("Contributors Skill Pool form in ENG/FR"));

    public ContributePage openContributePage() {
        open("/contribute/");

        return this;
    }

    public ContributePage ObserveSkillFormBtn () {
        btnSkillForm.should(exist);

        return this;
    }
}
