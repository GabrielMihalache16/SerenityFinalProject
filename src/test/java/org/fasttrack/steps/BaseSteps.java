package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrack.pages.*;
import utils.EnvConstants;

public class BaseSteps extends ScenarioSteps {
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public SearchResultPage searchResultPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public ProductPage productPage;
    public AdminLoginPage adminLoginPage;
    public AdminProductsPage adminProductsPage;
    public AdminHomePage adminHomePage;
    public ShopPage shopPage;


    @Step
    public void navigateToAdminHomePage(){
        getDriver().get(EnvConstants.ADMIN_BASE_URL);
    }

    @Step
    public void navigateToHomePage(){
        getDriver().get(EnvConstants.BASE_URL);
    }

    @Step
    public void navigateBack(){
        getDriver().navigate().back();
    }@Step
    public void refreshPage(){
        getDriver().navigate().refresh();
    }
}
