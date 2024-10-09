package com.solvd.saucedemoweb;

import org.testng.annotations.Test;

import com.zebrunner.agent.core.annotation.TestCaseKey;

import groovy.util.logging.Slf4j;

@Slf4j
public class LoginTest extends BaseTest {

    private static final String STANDARD_USER = "standard_user";

    private static final String LOCKED_USER = "locked_out_user";

    private static final String PASSWORD = "{crypt:WwobgI5k40XywUBHYUIF5g==}";

    @Test
    @TestCaseKey("ANDK-339")
    public void verifyLoginPageIsValidTest() {
        homeLoginService.openLoginPage();
        homeLoginService.validateThat().loginPageIsValid();
    }

    @Test
    @TestCaseKey("ANDK-334")
    public void verifyLoginForExistingUserTest() {
        homeLoginService.openLoginPage();
        homeLoginService.login(STANDARD_USER, PASSWORD);
        productsGridService.validateThat().productsGridPageIsOpened();
    }

    @Test
    @TestCaseKey("ANDK-336")
    public void verifyLoginForLockedUserTest() {
        homeLoginService.openLoginPage();
        homeLoginService.login(LOCKED_USER, PASSWORD);
        productsGridService.validateThat().productsGridPageIsNotOpened();
        homeLoginService.validateThat().userIsLocked();
    }

    @Test
    @TestCaseKey("ANDK-335")
    public void verifyRandomCredentialsLoginTest() {
        homeLoginService.openLoginPage();
        homeLoginService.login(LOCKED_USER, PASSWORD);
        productsGridService.validateThat().productsGridPageIsNotOpened();
        homeLoginService.validateThat().userIsLocked();
    }

}
