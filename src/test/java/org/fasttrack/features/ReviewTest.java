package org.fasttrack.features;

import org.junit.Test;

public class ReviewTest extends BaseTest {
    @Test
    public void writeReviewOnProduct(){
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
}
