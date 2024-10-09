package com.solvd.saucedemoweb.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.saucedemoweb.constant.Products;
import com.solvd.saucedemoweb.constant.TimeConstant;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class, 'inventory_item_name') and  contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate('%s','ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'))]")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//*[contains(@class, 'inventory_item_name') and  contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate('%s','ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'))]//..//..//button[contains(@id, 'remove')]")
    private ExtendedWebElement removeButton;

    @FindBy(xpath = "//*[@class='shopping_cart_badge']")
    private ExtendedWebElement headerCartItemsAmount;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("cart_url"));
    }

    public boolean isOpened() {
        return getCurrentUrl().equals(R.CONFIG.get("cart_url"));
    }

    public void clickRemoveButton(Products product) {
        this.removeButton.format(product.getProductTitle()).click();
    }

    public int getHeaderCartItemsAmount() {
        return Integer.parseInt(this.headerCartItemsAmount.getText());
    }

    public boolean isHeaderCartItemsAmountPresent() {
        return this.headerCartItemsAmount.isElementPresent(TimeConstant.ELEMENT_PRESENT_TIMEOUT);
    }

    public boolean isProductPresentByName(Products product) {
        return this.productName.format(product.getProductTitle()).isElementPresent(TimeConstant.ELEMENT_PRESENT_TIMEOUT);
    }

}
