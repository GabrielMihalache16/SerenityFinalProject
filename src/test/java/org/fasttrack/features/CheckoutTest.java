package org.fasttrack.features;

import org.junit.Test;

public class CheckoutTest extends BaseTest{
    @Test
    public void checkoutTest(){
        baseSteps.navigateToHomePage();
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
    }
}
