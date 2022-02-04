package org.fasttrack.features;

import org.junit.Test;

public class CartTest extends BaseTest{
    @Test
    public void addProductToCart(){
        baseSteps.navigateToHomePage();
        searchSteps.doSearch("Beanie");
        cartSteps.clickAddToCartButtonInSearchPageFirstProduct();
        cartSteps.clickOnViewCartButtonInSearch();
        cartSteps.assertLastItemIsAddedToCart("Beanie");
    }

    @Test
    public void checkCartTotalSummaryTest(){
        baseSteps.navigateToHomePage();
        searchSteps.doSearch("");
        cartSteps.clickAddToCartButtonInSearchPageFirstProduct();
        cartSteps.clickAddToCartButtonInSearchPageSecondProduct();
        cartSteps.clickOnViewCartButtonInSearch();
        cartSteps.checkSubtotalPriceIsDisplayedCorrectly();
        cartSteps.checkGrandTotalPriceIsCorrect();
    }

    @Test
    public void emptyCartTest(){
        baseSteps.navigateToHomePage();
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
        baseSteps.navigateToHomePage();
        searchSteps.doSearch("");
        cartSteps.clickAddToCartButtonInSearchPageFirstProduct();
        cartSteps.clickAddToCartButtonInSearchPageSecondProduct();
        cartSteps.clickOnViewCartButtonInSearch();
        cartSteps.isUndoButtonRight(); //assert
    }

    @Test
    public void changeItemQuantityInCart(){
        baseSteps.navigateToHomePage();
        searchSteps.doSearch("");
        cartSteps.clickAddToCartButtonInSearchPageFirstProduct();
        cartSteps.clickOnViewCartButtonInSearch();
        cartSteps.changeFirstItemInCartQuantity("3");
        cartSteps.clickUpdateCartButton();
        baseSteps.refreshPage();
        cartSteps.assertCartQuantityUpdated(3);
    }

    @Test
    public void returnToShopFromCart(){
        baseSteps.navigateToHomePage();
        cartSteps.cartButton();
        cartSteps.clickReturnToShopButton();
        cartSteps.assertOnShopPage();
    }

    @Test
    public void itemsSavedToCartAfterLoggingOut(){
        baseSteps.navigateToHomePage();
        loginSteps.doLogin();
        cartSteps.cartButton();
        cartSteps.removeCartItems();
        searchSteps.doSearch("");
        cartSteps.clickAddToCartButtonInSearchPageFirstProduct();
        cartSteps.clickAddToCartButtonInSearchPageSecondProduct();
        cartSteps.clickOnViewCartButtonInSearch();
        cartSteps.assertCartDifferentItemsNumber(2);
        loginSteps.doLogOut();
        loginSteps.doLogin();
        cartSteps.cartButton();
        cartSteps.assertCartDifferentItemsNumber(2);

        //empty the account cart
        cartSteps.removeCartItems();
        cartSteps.assertCartIsEmpty();
    }

    @Test
    public void editItemQuantityToZeroInCart(){
        baseSteps.navigateToHomePage();
        searchSteps.doSearch("");
        cartSteps.clickAddToCartButtonInSearchPageFirstProduct();
        cartSteps.clickOnViewCartButtonInSearch();
        cartSteps.changeFirstItemInCartQuantity("0");
        cartSteps.clickUpdateCartButton();
        cartSteps.assertCartIsEmpty();
    }

    @Test
    public void addRelatedProductToCart(){
        baseSteps.navigateToHomePage();
        searchSteps.clickOnHeaderSearchButton();
        searchSteps.fillInHeaderSearchButton("HOODIE");
        searchSteps.clickOnDoSearchButton();
        searchSteps.clickOnFirstSearchItem();
        cartSteps.clickOnFirstRelatedProductAddToCartButton();
        cartSteps.clickOnFirstRelatedProductViewCartButton();
        cartSteps.firstItemInCartIsPresent();
    }

    @Test
    public void applySetValueCoupon(){
        baseSteps.navigateToHomePage();
        searchSteps.doSearch("");
        cartSteps.clickAddToCartButtonInSearchPageFirstProduct();
        cartSteps.clickOnViewCartButtonInSearch();
        cartSteps.fillCouponCodeFieldBySetAmountCode("5off");
        cartSteps.clickOnApplyCouponButton();
        cartSteps.checkSubtotalPriceIsDisplayedCorrectly();
        cartSteps.checkGrandTotalPriceCorrectWithSetPriceCoupon();
    }
    
    @Test
    public void cantApplySameCouponMultipleTimes(){
        baseSteps.navigateToHomePage();
        searchSteps.doSearch("");
        cartSteps.clickAddToCartButtonInSearchPageFirstProduct();
        cartSteps.clickOnViewCartButtonInSearch();
        cartSteps.fillCouponCodeFieldBySetAmountCode("5off");
        cartSteps.clickOnApplyCouponButton();
        cartSteps.fillCouponCodeFieldBySetAmountCode("5off");
        cartSteps.clickOnApplyCouponButton();
        cartSteps.displayedMessageCouponAlreadyApplied();
        cartSteps.checkGrandTotalPriceCorrectWithSetPriceCoupon();
    }

    @Test
    public void applyMultipleDifferentCoupons(){
        baseSteps.navigateToHomePage();
        searchSteps.doSearch("");
        cartSteps.clickAddToCartButtonInSearchPageFirstProduct();
        cartSteps.clickOnViewCartButtonInSearch();
        cartSteps.fillCouponCodeFieldBySetAmountCode("5off");
        cartSteps.clickOnApplyCouponButton();
        cartSteps.fillCouponCodeFieldBySetAmountCode("10off");
        cartSteps.clickOnApplyCouponButton();
        cartSteps.displayedMessageCouponSuccesfullyApplied();
    }

    @Test
    public void applyNoCoupon(){
        baseSteps.navigateToHomePage();
        searchSteps.doSearch("");
        cartSteps.clickAddToCartButtonInSearchPageFirstProduct();
        cartSteps.clickOnViewCartButtonInSearch();
        cartSteps.clickOnApplyCouponButton();
        cartSteps.assertNoCouponApplied();
    }
}
