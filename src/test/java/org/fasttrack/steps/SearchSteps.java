package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class SearchSteps extends BaseSteps{
    @Step
    public void clickOnHeaderSearchButton(){
        homePage.clickHeaderSearchButton();
    }
    @Step
    public void fillInHeaderSearchButton(String product) {
        homePage.setHeaderSearchButton(product);
    }

    @Step
    public void clickOnDoSearchButton(){
        homePage.clickDoSearchButton();
    }

    @Step
    public void assertSearchIsCorrect(String product){
        Assert.assertTrue(searchResultPage.isSearchCorrect(product));
    }

    @Step
    public void doSearch(String product){
        homePage.clickHeaderSearchButton();
        homePage.setHeaderSearchButton(product);
        homePage.clickDoSearchButton();
        Assert.assertTrue(searchResultPage.isSearchCorrect(product));
    }

    @Step
    public void clickOnFirstSearchItem(){
        searchResultPage.clickFirstItemInSearch();
    }

    @Step
    public void selectSortByPriceAsc(){
        searchResultPage.selectAscendingPriceOption();
    }
    @Step
    public void selectSortByPriceDesc(){
        searchResultPage.selectDescendingPriceOption();
    }

    @Step
    public void isSearchSortAscendingCorrect(){
        searchResultPage.isPriceSortAscendingCorrect();
    }

    @Step
    public void isSearchSortDescendingCorrect(){
        searchResultPage.isPriceSortDescendingCorrect();
    }
}
