package org.fasttrack.features;

import org.junit.Test;

public class ProductTest extends BaseTest {
    @Test
    public void writeReviewOnProduct(){
        baseSteps.navigateToHomePage();
        searchSteps.clickOnHeaderSearchButton();
        searchSteps.fillInHeaderSearchButton("beanie");
        searchSteps.clickOnDoSearchButton();
        searchSteps.clickOnFirstSearchItem();
        reviewSteps.clickOnReviewTabButton();
        reviewSteps.clickOnFourStarButton();
        reviewSteps.fillReviewCommentField();
        reviewSteps.fillReviewNameField();
        reviewSteps.fillReviewEmailField();
        reviewSteps.clickOnSubmitReviewButton();
        reviewSteps.assertReviewDone();
    }

    @Test
    public void createNewProductOnSite(){
        adminProductSteps.navigateToAdminHomePage();
        adminLoginSteps.doAdminLogin();
        adminProductSteps.clickOnProductsButton();
        adminProductSteps.clickOnAddNewProductButton();
        adminProductSteps.fillProductNameTextBox("Iepure");
        adminProductSteps.clickOnPublishProductButton();
        adminProductSteps.clickOnViewProductButton();
        adminProductSteps.assertCreatedProductIsDisplayedOnSite("iepure");

        //remove item
        baseSteps.navigateBack();
        adminProductSteps.clickMoveCreatedItemToTrash();
        adminProductSteps.assertMovedToTrashMessage();
    }

    @Test
    public void productOutOfStock(){
        baseSteps.navigateToHomePage();
        searchSteps.clickOnHeaderSearchButton();
        searchSteps.fillInHeaderSearchButton("belt");
        searchSteps.clickOnDoSearchButton();
        productSteps.assertProductIsOutOfStock();
    }

    @Test
    public void addEdittedQuantityOfProductToCart(){
        baseSteps.navigateToHomePage();
        searchSteps.clickOnHeaderSearchButton();
        searchSteps.fillInHeaderSearchButton("HOODIE");
        searchSteps.clickOnDoSearchButton();
        searchSteps.clickOnFirstSearchItem();
        productSteps.editProductQuantity("3");
        productSteps.addProductToCart();
        productSteps.productAddedToCart("3");
        productSteps.viewCartFromDisplayedMessage();
    }

    @Test
    public void notAbleToAddZeroQuantityProductToCart(){
        baseSteps.navigateToHomePage();
        searchSteps.clickOnHeaderSearchButton();
        searchSteps.fillInHeaderSearchButton("");
        searchSteps.clickOnDoSearchButton();
        searchSteps.clickOnFirstSearchItem();
        productSteps.editProductQuantity("0");
        productSteps.addProductToCart();
        productSteps.productNotAddedToCart();
        cartSteps.cartButton();
        cartSteps.assertCartIsEmpty();
    }


}
