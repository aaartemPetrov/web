package com.solvd.saucedemoweb.service;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.solvd.saucedemoweb.page.HomeLoginPage;

public class HomeLoginService {

    private final HomeLoginPage homeLoginPage;
    private Validator validator = new Validator();

    private static final String EMPTY_USERNAME_ERROR_MESSAGE = "Epic sadface: Username is required";

    private static final String EMPTY_PASSWORD_ERROR_MESSAGE = "Epic sadface: Password is required";

    private static final String LOCKED_USER_ERROR_MESSAGE = "Epic sadface: Sorry, this user has been locked out.";

    public HomeLoginService(WebDriver webDriver) {
        this.homeLoginPage = new HomeLoginPage(webDriver);
    }

    public Validator validateThat() {
        return this.validator;
    }

    public void openLoginPage() {
        this.homeLoginPage.open();
    }

    public void login(String username, String password) {
        this.homeLoginPage.typeUsername(username);
        this.homeLoginPage.typePassword(password);
        this.homeLoginPage.clickLoginButton();
    }

    public class Validator {
        public void loginPageIsValid() {
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(homeLoginPage.isUserNameInputPresent(), "Username input isn't present.");
            softAssert.assertTrue(homeLoginPage.isPasswordInputPresent(), "Password input isn't present.");
            softAssert.assertTrue(homeLoginPage.isLoginButtonPresent(), "Login button isn't present.");
            homeLoginPage.clickLoginButton();
            softAssert.assertTrue(homeLoginPage.isErrorMessagePresent(), "Error message isn't present.");
            softAssert.assertTrue(homeLoginPage.isErrorMessageTextPresent(EMPTY_USERNAME_ERROR_MESSAGE), "Unfilled username field error message is incorrect.");
            homeLoginPage.typeUsername("qwerty");
            homeLoginPage.clickLoginButton();
            softAssert.assertTrue(homeLoginPage.isErrorMessagePresent(), "Error message isn't present.");
            softAssert.assertTrue(homeLoginPage.isErrorMessageTextPresent(EMPTY_PASSWORD_ERROR_MESSAGE), "Unfilled password field error message is incorrect.");
            softAssert.assertAll();
        }


        public void userIsLocked() {
            Assert.assertTrue(homeLoginPage.isErrorMessagePresent(), "Error message isn't present.");
            Assert.assertTrue(homeLoginPage.isErrorMessageTextPresent(LOCKED_USER_ERROR_MESSAGE), "Locked user error message is incorrect.");
        }

    }

}
