package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;

public class ReviewSteps extends BaseSteps{
    @Step
    public void clickOnReviewTabButton(){
        productPage.clickReviewTabButton();
    }
    @Step
    public void clickOnFourStarButton(){
        productPage.clickFourStarButton();
    }
    @Step
    public void fillReviewCommentField(){
        productPage.setReviewCommentField();
    }
    @Step
    public void fillReviewNameField(){
        productPage.setReviewNameField();
    }
    @Step
    public void fillReviewEmailField(){
        productPage.setReviewEmailField();
    }
    @Step
    public void clickOnSubmitReviewButton(){
        productPage.clickSubmitReview();
    }
    @Step
    public void assertReviewDone(){
        productPage.assertReviewWaitingApproval();
    }
}
