package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa4.fasttrackit.org:8008/")
public class HomePage extends BasePage {

    @FindBy(id = "menu-item-122")
    private WebElementFacade myAccountPageButton;

    @FindBy(css = ".header-search-button")
    private WebElementFacade headerSearchButton;

    @FindBy(css = ".header-search-input .search-field")
    private WebElementFacade headerSearchField;

    @FindBy(css = ".woocommerce-product-search input:nth-child(2)")
    private WebElementFacade doSearchButton;

    @FindBy(css = ".fa-shopping-cart")
    private WebElementFacade cartButton;

    public void clickAccountPage() {
        clickOn(myAccountPageButton);
    }

    public void clickHeaderSearchButton() {
        clickOn(headerSearchButton);
    }

    public void setHeaderSearchButton(String product) {
        typeInto(headerSearchField, product);
    }

    public void clickDoSearchButton() {
        clickOn(doSearchButton);
    }

    public void clickCartButton() {
        clickOn(cartButton);
    }



}

