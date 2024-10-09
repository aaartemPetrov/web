package com.solvd.saucedemoweb;

import org.testng.annotations.BeforeMethod;

import com.solvd.saucedemoweb.service.CartService;
import com.solvd.saucedemoweb.service.HomeLoginService;
import com.solvd.saucedemoweb.service.ProductsGridService;
import com.zebrunner.carina.core.AbstractTest;

import groovy.util.logging.Slf4j;

@Slf4j
public class BaseTest extends AbstractTest {

    protected HomeLoginService homeLoginService;
    protected ProductsGridService productsGridService;

    protected CartService cartService;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        this.homeLoginService = new HomeLoginService(getDriver());
        this.productsGridService = new ProductsGridService(getDriver());
        this.cartService = new CartService(getDriver());
    }

}
