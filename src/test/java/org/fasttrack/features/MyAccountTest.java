package org.fasttrack.features;

import org.junit.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static utils.EnvConstants.USER_PASS;

public class MyAccountTest extends BaseTest{
    @Test
    public void changePassword(){
        baseSteps.navigateToHomePage();
        loginSteps.doLogin();
        myAccountSteps.clickOnLeftAccountDetailsButton();
        myAccountSteps.fillCurrentPasswordField(USER_PASS);
        myAccountSteps.fillNewPasswordField("!Parola123");
        myAccountSteps.fillConfirmNewPasswordField("!Parola123");
        myAccountSteps.clickOnSaveChangesButton();
        myAccountSteps.assertPasswordChanged();
    }

    @Test
    public void changeFirstNameAndLastName(){
        baseSteps.navigateToHomePage();
        loginSteps.doLogin();
        myAccountSteps.clickOnLeftAccountDetailsButton();
        myAccountSteps.firstNameField();
        myAccountSteps.lastNameField();
        myAccountSteps.clickOnSaveChangesButton();
        loginSteps.navigateToLoginPage();
        myAccountSteps.clickOnLeftAccountDetailsButton();
        myAccountSteps.firstAndLastNameChanged();
    }

    @Test
    public void editBillingAddress(){
        baseSteps.navigateToHomePage();
        loginSteps.doLogin();
        myAccountSteps.clickOnLeftAddressesButton();
        myAccountSteps.clickOnEditBillingAddressButton();
        myAccountSteps.editCompanyFieldInBillingAddress();
        myAccountSteps.clickOnSaveAddressButton();
        myAccountSteps.assertCompanyNameIsChangedInBillingAddress();
    }

    @Test
    public void editShippingAddress(){
        baseSteps.navigateToHomePage();
        loginSteps.doLogin();
        myAccountSteps.clickOnLeftAddressesButton();
        myAccountSteps.clickOnclickEditShippingAddressButton();
        myAccountSteps.editCompanyFieldInShippingAddress();
        myAccountSteps.clickOnSaveAddressButton();
        myAccountSteps.assertCompanyNameIsChangedinShippingAddress();
    }

    @Test
    public void orderDateIsCorrectTest(){
        baseSteps.navigateToHomePage();
        loginSteps.doLogin();
        searchSteps.doSearch("T-Shirt");
        cartSteps.clickAddToCartButtonInSearchPageFirstProduct();
        cartSteps.clickOnViewCartButtonInSearch();
        cartSteps.proceedToCheckout();
        checkoutSteps.fillCheckoutFirstNameField("John");
        checkoutSteps.fillCheckoutLastNameField("Smith");
        checkoutSteps.fillCheckoutCompanyNameField("Coca-Cola");
        checkoutSteps.fillCheckoutStreetAddressField("Strada Marasesti");
        checkoutSteps.fillCheckoutCityField("Bucuresti");
        checkoutSteps.selectCheckoutCounty("B");
        checkoutSteps.fillPostcodeField("000000");
        checkoutSteps.fillPhoneField("0712345678");
        checkoutSteps.fillEmailField("gabi.mihalache16@yahoo.com");
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.assertOrderIsReceived();
        loginSteps.navigateToLoginPage();
        myAccountSteps.clickOnLeftOrdersButton();
        myAccountSteps.assertCurrentDateEqualsLastOrderDate();
    }
}
