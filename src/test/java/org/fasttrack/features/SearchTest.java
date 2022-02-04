package org.fasttrack.features;

import org.junit.Test;

public class SearchTest extends BaseTest{
    @Test
    public void simpleSearchForProduct(){
        baseSteps.navigateToHomePage();
        searchSteps.clickOnHeaderSearchButton();
        searchSteps.fillInHeaderSearchButton("beanie");
        searchSteps.clickOnDoSearchButton();
        searchSteps.assertSearchIsCorrect("Beanie");
    }

    @Test
    public void priceAscendingTest(){
        baseSteps.navigateToHomePage();
        searchSteps.clickOnHeaderSearchButton();
        searchSteps.fillInHeaderSearchButton("T-shirt");
        searchSteps.clickOnDoSearchButton();
        searchSteps.selectSortByPriceAsc();
        searchSteps.isSearchSortAscendingCorrect(); //assert
    }

    @Test
    public void priceDescendingTest(){
        baseSteps.navigateToHomePage();
        searchSteps.clickOnHeaderSearchButton();
        searchSteps.fillInHeaderSearchButton("T-shirt");
        searchSteps.clickOnDoSearchButton();
        searchSteps.selectSortByPriceDesc();
        searchSteps.isSearchSortDescendingCorrect(); //assert
    }

    @Test
    public void verifyCreatedProductIsDisplayedSearching(){
        adminProductSteps.navigateToAdminHomePage();
        adminLoginSteps.doAdminLogin();
        adminProductSteps.createNewProductInAdmin("iepure");
        baseSteps.navigateToHomePage();
        searchSteps.clickOnHeaderSearchButton();
        searchSteps.fillInHeaderSearchButton("iepure");
        searchSteps.clickOnDoSearchButton();
        searchSteps.isCreatedProductAvailableViaSearch("iepure"); //assert

        //remove item
        baseSteps.navigateBack();
        baseSteps.navigateBack();
        adminProductSteps.clickMoveCreatedItemToTrash();
        adminProductSteps.assertMovedToTrashMessage();
    }

    @Test
    public void noProductsInSearchResults(){
        baseSteps.navigateToHomePage();
        searchSteps.clickOnHeaderSearchButton();
        searchSteps.fillInHeaderSearchButton("GFDGFDGFD");
        searchSteps.clickOnDoSearchButton();
        searchSteps.assertNoProductsDisplayedInSearch();
    }

    @Test
    public void navigateToSecondSearchPage() {
        baseSteps.navigateToHomePage();
        searchSteps.clickOnHeaderSearchButton();
        searchSteps.fillInHeaderSearchButton("");
        searchSteps.clickOnDoSearchButton();
    }
}
