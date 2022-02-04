package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class AdminHomePage extends BasePage{
    @FindBy(css = ".menu-top-last > [href=\"edit.php?post_type=product\"]")
    private WebElementFacade productsButtonLeftMenu;

    @FindBy(css = "#meta-2 ul li:first-child a")
    private WebElementFacade siteAdminButton;

    public void clickProductsButton(){
        clickOn(productsButtonLeftMenu);
    }
}
