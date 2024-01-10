package org.tallinn.mark;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class StepTest {

    @BeforeEach
    void setup(){
        Selenide.open("http://51.250.6.164:3000/signin");
    }

    @Test
    public void incorrectCredentials() {
        //Selenide.open("http://51.250.6.164:3000/signin");
        $x("//input[@data-name= \"username-input\"]").setValue("Name");
        $x("//input[@data-name= \"password-input\"]").setValue("1234567889");
        $x("//button[@data-name= \"signIn-button\"]").click();

        $x("//div[@data-name= \"authorizationError-popup\"]").should(Condition.exist, Condition.visible);
    }
}
