package com.solvd.saucedemoweb;

import org.testng.annotations.Test;

import com.solvd.saucedemoweb.constant.Products;
import com.zebrunner.agent.core.annotation.TestCaseKey;

public class CartTest extends BaseTest {

    private static final String STANDARD_USER = "standard_user";

    private static final String PASSWORD = "{crypt:WwobgI5k40XywUBHYUIF5g==}";

    @Test
    @TestCaseKey({"ANDK-337", "ANDK-338"})
    public void addAndRemoveProductsToCart() {
        homeLoginService.openLoginPage();
        homeLoginService.login(STANDARD_USER, PASSWORD);

        productsGridService.validateThat().productsGridPageIsOpened();
        productsGridService.validateThat().isAddToCartButtonPresent(Products.SAUCE_LABS_BACKPACK);
        productsGridService.validateThat().isRemoveButtonNotPresent(Products.SAUCE_LABS_BACKPACK);
        productsGridService.clickAddToBagButton(Products.SAUCE_LABS_BACKPACK);
        productsGridService.validateThat().isAddToCartButtonNotPresent(Products.SAUCE_LABS_BACKPACK);
        productsGridService.validateThat().isRemoveButtonPresent(Products.SAUCE_LABS_BACKPACK);
        productsGridService.validateThat().isHeaderCartItemsAmountEquals(1);
        productsGridService.validateThat().isAddToCartButtonPresent(Products.SAUCE_LABS_ONESIE);
        productsGridService.validateThat().isRemoveButtonNotPresent(Products.SAUCE_LABS_ONESIE);
        productsGridService.clickAddToBagButton(Products.SAUCE_LABS_ONESIE);
        productsGridService.validateThat().isAddToCartButtonNotPresent(Products.SAUCE_LABS_ONESIE);
        productsGridService.validateThat().isRemoveButtonPresent(Products.SAUCE_LABS_ONESIE);
        productsGridService.validateThat().isHeaderCartItemsAmountEquals(2);
        productsGridService.clickHeaderCartIcon();

        cartService.validateThat().cartPageIsOpened();
        cartService.validateThat().isHeaderCartItemsAmountEquals(2);
        cartService.validateThat().isProductNamePresent(Products.SAUCE_LABS_BACKPACK);
        cartService.validateThat().isProductNamePresent(Products.SAUCE_LABS_ONESIE);
        cartService.clickRemoveButton(Products.SAUCE_LABS_BACKPACK);
        cartService.validateThat().isHeaderCartItemsAmountEquals(1);
        cartService.validateThat().isProductNameNotPresent(Products.SAUCE_LABS_BACKPACK);
        cartService.validateThat().isProductNamePresent(Products.SAUCE_LABS_ONESIE);
        cartService.clickRemoveButton(Products.SAUCE_LABS_ONESIE);
        cartService.validateThat().isProductNameNotPresent(Products.SAUCE_LABS_ONESIE);
        cartService.validateThat().isHeaderCartItemsAmountBadgeNotPresent();
    }

}
