package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;

public class AdminProductSteps extends BaseSteps{
    @Step
    public void clickOnProductsButton(){
        adminHomePage.clickProductsButton();
    }

    @Step
    public void clickOnAddNewProductButton(){
        adminProductsPage.clickAddNewProductButton();
    }

    @Step
    public void fillProductNameTextBox(String productName){
        adminProductsPage.setProductNameTextBox(productName);
    }

    @Step
    public void clickOnPublishProductButton(){
        adminProductsPage.clickPublishProductButton();
    }

    @Step
    public void clickOnViewProductButton(){
        adminProductsPage.clickViewProductButton();
    }

    @Step
    public void assertCreatedProductIsDisplayedOnSite(String productName){
        productPage.assertCreatedProductIsDisplayedOnSite(productName);
    }

    @Step
    public void clickMoveCreatedItemToTrash(){
        adminProductsPage.clickMoveCreatedItemToTrash();
    }

    @Step
    public void assertMovedToTrashMessage(){
        adminProductsPage.assertMovedToTrashMessage();
    }
    @Step
    public void createNewProductInAdmin(String productName){
        adminHomePage.clickProductsButton();
        adminProductsPage.clickAddNewProductButton();
        adminProductsPage.setProductNameTextBox(productName);
        adminProductsPage.clickPublishProductButton();
    }
}
