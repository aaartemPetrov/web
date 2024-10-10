package com.solvd.saucedemoweb;

import org.testng.annotations.Test;

import com.solvd.saucedemoweb.constant.Users;
import com.zebrunner.agent.core.annotation.TestCaseKey;

import groovy.util.logging.Slf4j;

@Slf4j
public class LoginTest extends BaseTest {

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
        homeLoginService.login(Users.STANDARD_USER, Users.PASSWORD);
        productsGridService.validateThat().productsGridPageIsOpened();
    }

    @Test
    @TestCaseKey("ANDK-336")
    public void verifyLoginForLockedUserTest() {
        homeLoginService.openLoginPage();
        homeLoginService.login(Users.LOCKED_USER, Users.PASSWORD);
        productsGridService.validateThat().productsGridPageIsNotOpened();
        homeLoginService.validateThat().userIsLocked();
    }

    @Test
    @TestCaseKey("ANDK-335")
    public void verifyRandomCredentialsLoginTest() {
        homeLoginService.openLoginPage();
        homeLoginService.login(Users.LOCKED_USER, Users.PASSWORD);
        productsGridService.validateThat().productsGridPageIsNotOpened();
        homeLoginService.validateThat().userIsLocked();
    }

}
