package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CartSteps extends BaseSteps{
    @Step
    public void clickAddToCartButtonInSearchPageFirstProduct(){
        searchResultPage.clickAddToCartButtonFirstSearchProduct();
    }

    @Step
    public void clickAddToCartButtonInSearchPageSecondProduct(){
        searchResultPage.clickAddToCartButtonSecondSearchProduct();
    }
    @Step
    public void clickAddToCartButtonInSearchPageThirdProduct(){
        searchResultPage.clickAddToCartButtonThirdSearchProduct();
    }
    @Step
    public void cartButton(){
        homePage.clickCartButton();
    }
    @Step
    public void removeAnItemFromCart(){
        cartPage.removeItem();
    }

    @Step
    public void addThreeProductsToCart(){
        clickAddToCartButtonInSearchPageFirstProduct();
        clickAddToCartButtonInSearchPageSecondProduct();
        clickAddToCartButtonInSearchPageThirdProduct();
    }

    @Step
    public void removeCartItems(){
        cartPage.removeAllItemsFromCart();
    }
    @Step
    public void assertCartIsEmpty(){
        cartPage.shoppingCartEmpty();
    }

    @Step
    public void clickOnViewCartButtonInSearch(){
        searchResultPage.clickViewCartButtonInSearch();
    }

    @Step
    public void assertLastItemIsAddedToCart(String item){
        Assert.assertTrue(cartPage.isLastItemAdded(item));
    }

    @Step
    public void proceedToCheckout(){
        cartPage.clickProceedToCheckoutButton();
    }

    @Step
    public void isUndoButtonRight(){
        cartPage.isUndoButtonCorrect();
    }

    @Step
    public void checkSubtotalPriceIsDisplayedCorrectly(){
        Assert.assertTrue("The subtotal price is not correct!",cartPage.isSubtotalPriceCorrect());
    }

    @Step
    public void checkGrandTotalPriceIsCorrect(){
        Assert.assertTrue("Total price not correct!", cartPage.isGrandTotalPriceCorrect());
    }

}


