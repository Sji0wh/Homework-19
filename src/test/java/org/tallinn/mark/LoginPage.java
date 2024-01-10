package org.tallinn.mark;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    public SelenideElement login =  $x("//*[@data-name='username-input']");
    public SelenideElement password =  $x("//*[@data-name='password-input']");
    public SelenideElement signInButton = $x("//*[@data-name='signIn-button']");
    public SelenideElement errorIncorrectCredentials =  $x("//*[@data-name='authorizationError-popup']");
    public SelenideElement popUpCloseButton = $x("//*[@data-name='authorizationError-popup-close-button']");
    public SelenideElement usernameInputError = $x("//*[@data-name='username-input-error']");

}
