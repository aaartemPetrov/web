package com.solvd.saucedemoweb.page;

import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.saucedemoweb.constant.TimeConstant;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class HomeLoginPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='user-name']")
    private ExtendedWebElement userNameInput;

    @FindBy(xpath = "//*[@id='password']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//*[@id='login-button']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//*[@data-test='error']")
    private ExtendedWebElement errorMessage;

    public HomeLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserNameInputPresent() {
        return this.userNameInput.isElementPresent(TimeConstant.ELEMENT_PRESENT_TIMEOUT);
    }

    public boolean isPasswordInputPresent() {
        return this.passwordInput.isElementPresent(TimeConstant.ELEMENT_PRESENT_TIMEOUT);
    }

    public boolean isLoginButtonPresent() {
        return this.loginButton.isElementPresent(TimeConstant.ELEMENT_PRESENT_TIMEOUT);
    }

    public boolean isErrorMessagePresent() {
        return this.errorMessage.isElementPresent(TimeConstant.ELEMENT_PRESENT_TIMEOUT);
    }

    public void typeUsername(String text) {
        this.userNameInput.type(text);
    }

    public void typePassword(String text) {
        this.passwordInput.type(text);
    }

    public void clickLoginButton() {
        this.loginButton.click();
    }

    public boolean isErrorMessageTextPresent(String text) {
        return text.toLowerCase(Locale.ROOT).trim().equals(this.errorMessage.getText().toLowerCase(Locale.ROOT).trim());
    }

}
