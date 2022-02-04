package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;

public class ProductSteps extends BaseSteps{
    @Step
    public void assertProductIsOutOfStock(){
        productPage.assertProductOutOfStock();
    }

    @Step
    public void editProductQuantity(String quantityValue){
        productPage.editProductQuantity(quantityValue);
    }

    @Step
    public void addProductToCart(){
        productPage.clickAddToCartButton();
    }

    @Step
    public void productAddedToCart(String quantityValue){
        productPage.assertProductQuantityIsAddedToCart(quantityValue);
    }

    @Step
    public void viewCartFromDisplayedMessage(){
        productPage.clickViewCart();
    }

    @Step
    public void productNotAddedToCart(){
        productPage.assertProductWithoutQuantityNotAddedToCart();
    }
}
