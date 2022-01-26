package org.fasttrack.features;

import org.junit.Test;

public class SearchTest extends BaseTest{
    @Test
    public void simpleSearchForProduct(){
        searchSteps.clickOnHeaderSearchButton();
        searchSteps.fillInHeaderSearchButton("beanie");
        searchSteps.clickOnDoSearchButton();
        searchSteps.assertSearchIsCorrect("Beanie");
    }

    @Test
    public void priceAscendingTest(){
        searchSteps.clickOnHeaderSearchButton();
        searchSteps.fillInHeaderSearchButton("T-shirt");
        searchSteps.clickOnDoSearchButton();
        searchSteps.selectSortByPriceAsc();
        searchSteps.isSearchSortAscendingCorrect(); //assert
    }

    @Test
    public void priceDescendingTest(){
        searchSteps.clickOnHeaderSearchButton();
        searchSteps.fillInHeaderSearchButton("T-shirt");
        searchSteps.clickOnDoSearchButton();
        searchSteps.selectSortByPriceDesc();
        searchSteps.isSearchSortDescendingCorrect(); //assert
    }
}
