package com.openfoodfacts.web.tests;

import com.openfoodfacts.web.pages.SignInPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SignInTests extends TestBase {
    SignInPage signInPage = new SignInPage();

    @Test
    @Tag("uiAuto")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("ma-lyna")
    @DisplayName("Successful sign in")
    void checkSuccessfulSearch() {
        step("Open the 'Sign in' page", () -> {
            signInPage.openSignInPage();
        });
        step("Enter username", () -> {
            signInPage.enterUsername("etamki");
        });
        step("Enter password", () -> {
            signInPage.enterPassword("Testproject");
        });
        step("Tap on the 'Sign in' button", () -> {
            signInPage.tapToSignIn();
        });
        step("Verify you are successfully signed in", () -> {
            signInPage.checkSignInText();
        });
    }

    @Test
    @Tag("uiAuto")
    @Severity(SeverityLevel.NORMAL)
    @Owner("ma-lyna")
    @DisplayName("Successful sign in")
    void checkUnsuccessfulSearch() {
        step("Open the 'Sign in' page", () -> {
            signInPage.openSignInPage();
        });
        step("Enter username", () -> {
            signInPage.enterUsername("etamki");
        });
        step("Enter password", () -> {
            signInPage.enterPassword("T");
        });
        step("Tap on the 'Sign in' button", () -> {
            signInPage.tapToSignIn();
        });
        step("Verify Error is displayed", () -> {
            signInPage.checkErrorText();
        });
    }
}
