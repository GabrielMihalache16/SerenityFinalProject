package org.fasttrack.features;

import org.junit.Test;

public class CartTest extends BaseTest{
    @Test
    public void addProductToCart(){
        loginSteps.doLogin();
        searchSteps.doSearch("Beanie");
        cartSteps.clickAddToCartButtonInSearchPageFirstProduct();
        cartSteps.clickOnViewCartButtonInSearch();
        cartSteps.assertLastItemIsAddedToCart("Beanie");
    }

    @Test
    public void checkCartTotalSummaryTest(){
        searchSteps.doSearch("");
        cartSteps.clickAddToCartButtonInSearchPageFirstProduct();
        cartSteps.clickAddToCartButtonInSearchPageSecondProduct();
        cartSteps.clickOnViewCartButtonInSearch();
        cartSteps.checkSubtotalPriceIsDisplayedCorrectly();
        cartSteps.checkGrandTotalPriceIsCorrect();
    }

    @Test
    public void emptyCartTest(){
        searchSteps.clickOnHeaderSearchButton();
        searchSteps.fillInHeaderSearchButton("");
        searchSteps.clickOnDoSearchButton();
        cartSteps.addThreeProductsToCart();
        cartSteps.cartButton();
        cartSteps.removeCartItems();
        cartSteps.assertCartIsEmpty();
    }

    @Test
    public void undoCartFunctionTest(){
        searchSteps.doSearch("");
        cartSteps.clickAddToCartButtonInSearchPageFirstProduct();
        cartSteps.clickAddToCartButtonInSearchPageSecondProduct();
        cartSteps.clickOnViewCartButtonInSearch();
        cartSteps.isUndoButtonRight(); //assert
    }
}
