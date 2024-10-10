package com.solvd.saucedemoweb.page.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.saucedemoweb.constant.TimeConstant;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class HeaderComponent extends AbstractUIObject {

    @FindBy(xpath = ".//*[@id='shopping_cart_container']")
    private ExtendedWebElement headerCartIcon;

    @FindBy(xpath = ".//*[@class='shopping_cart_badge']")
    private ExtendedWebElement headerCartItemsAmount;

    public HeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public int getHeaderCartItemsAmount() {
        return Integer.parseInt(this.headerCartItemsAmount.getText());
    }

    public boolean isHeaderCartItemsAmountPresent() {
        return this.headerCartItemsAmount.isElementPresent(TimeConstant.ELEMENT_PRESENT_TIMEOUT);
    }

    public void clickHeaderCartIcon() {
        this.headerCartIcon.click();
    }

    public  boolean isHeaderCartIconPresent() {
        return this.headerCartIcon.isPresent(TimeConstant.ELEMENT_PRESENT_TIMEOUT);
    }

}
