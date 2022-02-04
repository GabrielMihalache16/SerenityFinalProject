package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ShopPage extends BasePage{
    @FindBy(css = ".page-title")
    private WebElementFacade pageTitle;

    @FindBy (css = ".orderby")
    private WebElementFacade sortButtonInSearch;


    public boolean isShopFilterAvailable(){
        return sortButtonInSearch.isPresent();
    }

    public boolean isPageTitleShop(){
        return pageTitle.getText().equalsIgnoreCase("Shop");
    }
}
