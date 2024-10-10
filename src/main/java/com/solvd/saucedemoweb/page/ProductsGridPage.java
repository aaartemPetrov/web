package com.solvd.saucedemoweb.page;

import java.sql.Time;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.saucedemoweb.constant.Products;
import com.solvd.saucedemoweb.constant.TimeConstant;
import com.solvd.saucedemoweb.page.components.HeaderComponent;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class ProductsGridPage extends AbstractPage {

    @FindBy(xpath = "//*[@class = 'inventory_item']//*[contains(@class, 'inventory_item_name') and  contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate('%s','ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'))]//..//..//..//button[contains(@id, 'add-to-cart')]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//*[@class = 'inventory_item']//*[contains(@class, 'inventory_item_name') and  contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate('%s','ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'))]//..//..//..//button[contains(@id, 'remove')]")
    private ExtendedWebElement removeButton;

    @FindBy(xpath = "//*[@id='header_container']")
    private HeaderComponent header;

    public ProductsGridPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("inventory.html");
    }

    public HeaderComponent getHeader() {
        return this.header;
    }

    public boolean isOpened() {
        return isPageOpened(TimeConstant.PAGE_OPENING_TIMEOUT);
    }

    public void clickAddToCartButton(Products product) {
        this.addToCartButton.format(product.getProductTitle()).click();
    }

    public void clickRemoveButton(Products product) {
        this.removeButton.format(product.getProductTitle()).click();
    }

    public boolean isAddToCartButtonPresent(Products product) {
        return addToCartButton.format(product.getProductTitle()).isElementPresent(TimeConstant.ELEMENT_PRESENT_TIMEOUT);
    }

    public boolean isRemoveButtonPresent(Products product) {
        return removeButton.format(product.getProductTitle()).isElementPresent(TimeConstant.ELEMENT_PRESENT_TIMEOUT);
    }

}
