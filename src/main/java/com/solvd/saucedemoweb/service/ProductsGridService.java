package com.solvd.saucedemoweb.service;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.solvd.saucedemoweb.constant.Products;
import com.solvd.saucedemoweb.page.ProductsGridPage;

public class ProductsGridService {

    private final ProductsGridPage productsGridPage;

    private Validator validator = new Validator();

    public ProductsGridService(WebDriver webDriver) {
        this.productsGridPage = new ProductsGridPage(webDriver);
    }

    public Validator validateThat() {
        return this.validator;
    }

    public void openProductsGridPage() {
        this.productsGridPage.open();
    }

    public void clickAddToBagButton(Products product) {
        this.productsGridPage.clickAddToCartButton(product);
    }

    public void clickHeaderCartIcon() {
        this.productsGridPage.clickHeaderCartIcon();
    }

    public class Validator {

        public void productsGridPageIsOpened() {
            Assert.assertTrue(productsGridPage.isOpened(), "Products grid page isn't opened");
        }

        public void productsGridPageIsNotOpened() {
            Assert.assertTrue(!productsGridPage.isOpened(), "Products grid page is opened");
        }

        public void isAddToCartButtonPresent(Products product) {
            Assert.assertTrue(productsGridPage.isAddToCartButtonPresent(product), String.format("Add to cart button isn't present for product: %s", product.getProductTitle()));
        }

        public void isAddToCartButtonNotPresent(Products product) {
            Assert.assertFalse(productsGridPage.isAddToCartButtonPresent(product), String.format("Add to cart button present for product: %s", product.getProductTitle()));
        }

        public void isRemoveButtonPresent(Products product) {
            Assert.assertTrue(productsGridPage.isRemoveButtonPresent(product), String.format("Remove button isn't present for product: %s", product.getProductTitle()));
        }

        public void isRemoveButtonNotPresent(Products product) {
            Assert.assertFalse(productsGridPage.isRemoveButtonPresent(product), String.format("Remove button is present for product: %s", product.getProductTitle()));
        }

        public void isHeaderCartItemsAmountEquals(int amount) {
            Assert.assertEquals(productsGridPage.getHeaderCartItemsAmount(), amount, "Wrong header cart icon amount.");
        }

    }

}
