package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import java.util.Locale;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class ProductPage extends BasePage{
    @FindBy (id = "tab-title-reviews")
    private WebElementFacade reviewTabButton;

    @FindBy (css = ".product_title")
    private WebElementFacade productTitle;

    @FindBy (css = ".star-4")
    private WebElementFacade fourStarButton;

    @FindBy (id = "comment")
    private WebElementFacade reviewCommentField;

    @FindBy (id = "author")
    private WebElementFacade reviewNameField;

    @FindBy (id = "email")
    private WebElementFacade reviewEmailField;

    @FindBy (id = "submit")
    private WebElementFacade submitReviewButton;

    @FindBy (css = ".comment-text")
    private WebElementFacade reviewWaitingApproval;

    @FindBy (css = ".out-of-stock")
    private WebElementFacade productOutOfStock;

    @FindBy (css = ".single_add_to_cart_button")
    private WebElementFacade addToCartButton;

    @FindBy (css = ".woocommerce-message")
    private WebElementFacade productPageMessage;

    @FindBy (css = ".woocommerce-message .button")
    private WebElementFacade viewCartButtonFromProductPageMessage;

    @FindBy (css = ".qty")
    private WebElementFacade quantityOfProduct;

    @FindBy (css = ".columns-4 li:first-child .button")
    private WebElementFacade firstRelatedProductAddToCartButton;

    @FindBy (css = ".columns-4 li:first-child .added_to_cart")
    private WebElementFacade firstRelatedProductViewCartButton;

    public void clickReviewTabButton(){
        clickOn(reviewTabButton);
    }

    public void clickFirstRelatedProductAddToCartButton(){
        clickOn(firstRelatedProductAddToCartButton);
    }

    public void clickFirstRelatedProductViewCartButton(){
        clickOn(firstRelatedProductViewCartButton);
    }

    public void clickFourStarButton(){
        clickOn(fourStarButton);
    }

    public void clickSubmitReview(){
        clickOn(submitReviewButton);
    }

    public void setReviewCommentField() {
        String randComment = randomAlphabetic(9, 20);
        typeInto(reviewCommentField, randComment);
    }

    public void setReviewNameField() {
        String randName = randomAlphabetic(6, 10);
        typeInto(reviewNameField, randName);
    }

    public void setReviewEmailField(){
        String randEmail = randomAlphabetic(9, 14);
        typeInto(reviewEmailField, randEmail+"@gmail.com");
        System.out.println("The review email is: " + randEmail + "@gmail.com");
    }

    public void assertReviewWaitingApproval(){
        waitFor(reviewWaitingApproval);
        Assert.assertTrue(reviewWaitingApproval.isPresent());
    }

    public void assertCreatedProductIsDisplayedOnSite(String productName){
        Assert.assertTrue(getDriver().getCurrentUrl().contains(productName));
        Assert.assertTrue(productTitle.getText().equalsIgnoreCase(productName));
    }

    public boolean isProductTitleIsDisplayed(){
        if (productTitle.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean isProductTitleIsCorrectFromSearch(String productName){
        if (productTitle.getText().equalsIgnoreCase(productName)){
            return true;
        }
        return false;
    }

    public void assertProductOutOfStock(){
        Assert.assertTrue(productOutOfStock.isDisplayed());
        Assert.assertFalse(addToCartButton.isPresent());
        Assert.assertEquals("Out of stock", productOutOfStock.getText());
    }

    public void editProductQuantity(String quantityValue){
        typeInto(quantityOfProduct, quantityValue);
    }

    public void clickAddToCartButton(){
        clickOn(addToCartButton);
    }

    public void clickViewCart(){
        clickOn(viewCartButtonFromProductPageMessage);
    }

    public void assertProductQuantityIsAddedToCart(String quantityValue){
        String message = productPageMessage.getText().toLowerCase();
        Assert.assertTrue(message.contains(quantityValue) && message.contains(productTitle.getText().toLowerCase()));
    }

    public void assertProductWithoutQuantityNotAddedToCart(){
        Assert.assertFalse(productPageMessage.isPresent());
    }


}
