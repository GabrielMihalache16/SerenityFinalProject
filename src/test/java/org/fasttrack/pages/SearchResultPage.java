package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchResultPage extends BasePage{
    @FindBy(id = "primary")
    private List<WebElementFacade> productsList;

    @FindBy (css = ".azera_shop_grid_first li:first-child a:last-child")
    private WebElementFacade addToCartButtonFirstSearchProduct;

    @FindBy (css = ".azera_shop_grid_column_2 li:first-child a:nth-child(2)")
    private WebElementFacade addToCartButtonSecondSearchProduct;

    @FindBy (css = ".azera_shop_grid_column_3 li:first-child a:nth-child(2)")
    private WebElementFacade addToCartButtonThirdSearchProduct;

    @FindBy(css = ".azera_shop_grid_first li:first-child h2")
    private WebElementFacade searchResultFirstItem;

    @FindBy (css = ".added_to_cart")
    private WebElementFacade viewCartButtonInSearch;

    @FindBy (css = ".orderby")
    private WebElementFacade sortButtonInSearch;

    @FindBy (css = ".price :not(del) .woocommerce-Price-amount, .price>.amount")
    private List<WebElementFacade> priceListInSearch;

    @FindBy (css = ".woocommerce-info")
    private WebElementFacade noProductsInSearchResultsMessage;


    public boolean isSearchCorrect(String name){
        for (WebElementFacade element : productsList){
            if (element.findElement(By.cssSelector(".azera_shop_grid_first li:first-child h2")).getText().contains(name)){
                return true;
            }
        }
        return false;
    }

    public void clickAddToCartButtonFirstSearchProduct(){
        clickOn(addToCartButtonFirstSearchProduct);
    }

    public void clickAddToCartButtonSecondSearchProduct(){
        clickOn(addToCartButtonSecondSearchProduct);
    }

    public void clickAddToCartButtonThirdSearchProduct(){
        clickOn(addToCartButtonThirdSearchProduct);
    }

    public void clickViewCartButtonInSearch(){
        clickOn(viewCartButtonInSearch);
    }

    public void clickFirstItemInSearch(){
        clickOn(searchResultFirstItem);
    }

    public void selectAscendingPriceOption(){
        Select options = new Select(sortButtonInSearch);
        options.selectByValue("price");
    }

    public void selectDescendingPriceOption(){
        Select options = new Select(sortButtonInSearch);
        options.selectByValue("price-desc");
    }

    public boolean isPriceSortAscendingCorrect(){
        for (WebElementFacade element : priceListInSearch){
            int count = 0;
            int count2 = count+1;
            int a = getIntFromPrice(priceListInSearch.get(count++).getText());
            int b = getIntFromPrice(priceListInSearch.get(count2).getText());
            if(a < b){
                return true;

            }
        }
        return false;
    }

    public boolean isPriceSortDescendingCorrect(){
        for (WebElementFacade element : priceListInSearch){
            int count = 0;
            int count2 = count+1;
            int a = getIntFromPrice(priceListInSearch.get(count++).getText());
            int b = getIntFromPrice(priceListInSearch.get(count2).getText());
            if(a > b){
                return true;

            }
        }
        return false;
    }

    public boolean assertFirstSearchProductIsDisplayed(){
        if (searchResultFirstItem.isDisplayed()){
            return true;
        }
        return false;
    }

    public void noProductsDisplayedInSearch(){
        Assert.assertFalse(sortButtonInSearch.isPresent());
        Assert.assertFalse(searchResultFirstItem.isPresent());
        Assert.assertEquals("No products were found matching your selection.", noProductsInSearchResultsMessage.getText());
    }

}
