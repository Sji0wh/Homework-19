package org.tallinn.mark;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class OrderPage {

    public SelenideElement orderName =  $x("//*[@data-name='username-input']");
    public SelenideElement phone = $x("//*[@data-name='phone-input']");
    public SelenideElement comment = $x("//*[@data-name='comment-input']");
    public  SelenideElement orderButton = $x("//*[@data-name='createOrder-button']");

    public SelenideElement successfulOrderCreation =  $x("//*[@data-name='orderSuccessfullyCreated-popup']");

}
