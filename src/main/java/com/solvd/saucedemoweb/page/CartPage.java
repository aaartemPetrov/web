package com.solvd.saucedemoweb.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.saucedemoweb.constant.Products;
import com.solvd.saucedemoweb.constant.TimeConstant;
import com.solvd.saucedemoweb.page.components.HeaderComponent;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class, 'inventory_item_name') and  contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate('%s','ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'))]")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//*[contains(@class, 'inventory_item_name') and  contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate('%s','ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'))]//..//..//button[contains(@id, 'remove')]")
    private ExtendedWebElement removeButton;

    @FindBy(xpath = "//*[@id='header_container']")
    private HeaderComponent header;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("cart.html");
    }

    public HeaderComponent getHeader() {
        return this.header;
    }

    public boolean isOpened() {
        return isPageOpened(TimeConstant.PAGE_OPENING_TIMEOUT);
    }

    public void clickRemoveButton(Products product) {
        this.removeButton.format(product.getProductTitle()).click();
    }

    public boolean isProductPresentByName(Products product) {
        return this.productName.format(product.getProductTitle()).isElementPresent(TimeConstant.ELEMENT_PRESENT_TIMEOUT);
    }

}
