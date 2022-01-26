package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class ProductPage extends BasePage{
    @FindBy (id = "tab-title-reviews")
    private WebElementFacade reviewTabButton;

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

    public void clickReviewTabButton(){
        clickOn(reviewTabButton);
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
}
