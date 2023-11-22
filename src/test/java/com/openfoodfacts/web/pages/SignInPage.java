package com.openfoodfacts.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignInPage {

    private SelenideElement
            usernameInput = $("input[id ='login_user_id']"),
            passwordInput = $("input[id ='login_user_password']"),
            signInBtn = $("input[id ='submit']"),
            signInText = $(withText("Hello Marina")),
            errorText = $(withText("Incorrect user name or password"));

    public SignInPage openSignInPage() {
        open("/cgi/session.pl/");

        return this;
    }


    public SignInPage enterUsername (String value) {
        usernameInput.setValue(value);

        return this;
    }

    public SignInPage enterPassword(String value) {
        passwordInput.setValue(value);

        return this;
    }

    public SignInPage tapToSignIn () {
        signInBtn.click();

        return this;
    }

    public SignInPage checkSignInText () {
        signInText.should(exist);

        return this;
    }

    public SignInPage checkErrorText () {
        errorText.should(exist);

        return this;
    }
}
