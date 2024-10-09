package com.solvd.saucedemoweb.service;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.solvd.saucedemoweb.constant.Products;
import com.solvd.saucedemoweb.page.CartPage;


public class CartService {

    private final CartPage cartPage;

    private Validator validator = new Validator();

    public CartService(WebDriver webDriver) {
        this.cartPage = new CartPage(webDriver);
    }

    public Validator validateThat() {
        return this.validator;
    }

    public void clickRemoveButton(Products product) {
        this.cartPage.clickRemoveButton(product);
    }

    public class Validator {

        public void cartPageIsOpened() {
            Assert.assertTrue(cartPage.isOpened(), "Products grid page isn't opened");
        }

        public void isHeaderCartItemsAmountEquals(int amount) {
            Assert.assertEquals(cartPage.getHeaderCartItemsAmount(), amount, "Wrong header cart icon amount.");
        }

        public void isHeaderCartItemsAmountBadgeNotPresent() {
            Assert.assertFalse(cartPage.isHeaderCartItemsAmountPresent(), "Header cart items amount badge present for 0 items in the cart.");
        }

        public void isProductNamePresent(Products product) {
            Assert.assertTrue(cartPage.isProductPresentByName(product), String.format("Product name isn't present for product %s.", product.getProductTitle()));
        }

        public void isProductNameNotPresent(Products product) {
            Assert.assertFalse(cartPage.isProductPresentByName(product), String.format("Product name is present for product %s.", product.getProductTitle()));
        }

    }

}
