package com.openfoodfacts.tests.web;

import com.openfoodfacts.pages.ContributePage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ContributeTests extends TestBase {
    ContributePage contributePage = new ContributePage();
    @Test
    @Tag("uiAuto")
    @Severity(SeverityLevel.NORMAL)
    @Owner("ma-lyna")
    @DisplayName("Observe button for contributors Skill Pool form")
    void checkSkillFormBtn() {
        step("Open the 'Contribute' page", () -> {
            contributePage.openContributePage();
        });
        step("Verify there is button for contributors Skill Pool form", () -> {
            contributePage.ObserveSkillFormBtn();
        });
    }
}
