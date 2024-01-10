package org.tallinn.mark;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.conditions.Or;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginTest {

        LoginPage loginPage = new LoginPage();
        OrderPage orderPage = new OrderPage();

@BeforeAll
public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        }

@BeforeEach
public void setUp() {
        open("http://51.250.6.164:3000/signin");
        Selenide.localStorage().removeItem("jwt");
//        Selenide.localStorage().setItem("jwt", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJrYXFhIiwiZXhwIjoxNzAxMjEzODgzLCJpYXQiOjE3MDExOTU4ODN9.jnR6_-RX81bAeImlTV7t5Mj3LA_6KbZqPqzIqSJmcZL4_GwswxPfJGmhUuGAfN07FEBZpVKC5nJNzlA25QgV5w");
        Selenide.refresh();
}

        @AfterEach
        public void tearDown() {
        Selenide.closeWebDriver();
        }

        //Incorrect credentials error check
        @Test
        public void incorrectCredentials() {
        loginPage.login.sendKeys("login");
        loginPage.password.sendKeys("password");
        loginPage.signInButton.click();
        loginPage.errorIncorrectCredentials.shouldBe(visible);
        }

        //Correct credentials check
        @Test
        public void correctDataOrderButtonCheck() {
                loginPage.login.sendKeys("markaqa");
                loginPage.password.sendKeys("p5Twdy789");
                loginPage.signInButton.click();
                orderPage.orderButton.shouldBe(Condition.exist, visible);
        }

        //Login with incorrect data and check the error and then re-login successfully
        @Test
        public void loginWithCorrectCredentialsAfterIncorrect() {
                loginPage.login.sendKeys("login");
                loginPage.password.sendKeys("password");
                loginPage.signInButton.click();
                loginPage.errorIncorrectCredentials.shouldBe(visible);
                loginPage.popUpCloseButton.click();
                loginPage.login.clear();
                loginPage.login.sendKeys("markaqa");
                loginPage.password.clear();
                loginPage.password.sendKeys("p5Twdy789");
                loginPage.signInButton.click();
                orderPage.orderButton.shouldBe(Condition.exist, visible);
        }

        //Error checking using a minimum number of characters (2 scenario)
        @Test
        public void insertAMinimumNumberOfTwoCharactersInLogin() {
                loginPage.login.sendKeys("2");
                loginPage.password.sendKeys("12");
                loginPage.usernameInputError.shouldBe(Condition.exist, visible);
        }


        @Test
        public void signInButtonIsDisabled () {
                loginPage.login.sendKeys("login");
                loginPage.signInButton.shouldBe(visible);
        }

        @Test
        public void insertPasswordWithEmptyLogin () {
        loginPage.password.sendKeys("login");
        loginPage.signInButton.should(Condition.disabled);
        }

//        @Test
//        public void orderCreation() {
//                open("http://51.250.6.164:3000/signin");
//                Selenide.localStorage().setItem("jwt", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJrYXFhIiwiZXhwIjoxNzAxMjEzODgzLCJpYXQiOjE3MDExOTU4ODN9.jnR6_-RX81bAeImlTV7t5Mj3LA_6KbZqPqzIqSJmcZL4_GwswxPfJGmhUuGAfN07FEBZpVKC5nJNzlA25QgV5w");
//                Selenide.refresh();
//                orderPage.orderName.sendKeys("Order2020030214");
//                orderPage.phone.sendKeys("56668897846");
//                orderPage.comment.sendKeys("Comment");
//                orderPage.orderButton.click();
//                orderPage.successfulOrderCreation.should(visible);
//        }
}
