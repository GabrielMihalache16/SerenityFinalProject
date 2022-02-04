package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CheckoutSteps extends BaseSteps{
    @Step
    public void fillCheckoutFirstNameField(String firstName){
        checkoutPage.setCheckoutFirstNameField(firstName);
    }

    @Step
    public void fillCheckoutLastNameField(String lastName){
        checkoutPage.setCheckoutLastNameField(lastName);
    }

    @Step
    public void fillCheckoutCompanyNameField(String companyName){
        checkoutPage.setCheckoutCompanyNameField(companyName);
    }

    @Step
    public void fillCheckoutStreetAddressField(String streetAddress){
        checkoutPage.setCheckoutStreetAddressField(streetAddress);
    }

    @Step
    public void fillCheckoutCityField(String city){
        checkoutPage.setCheckoutCityField(city);
    }

    @Step
    public void selectCheckoutCounty(String cityInitials){
        checkoutPage.selectCheckoutCountySelect(cityInitials);
    }

    @Step
    public void fillPostcodeField(String postcode){
        checkoutPage.setCheckoutPostcodeField(postcode);
    }

    @Step
    public void fillPhoneField(String phoneNumber){
        checkoutPage.setCheckoutPhoneField(phoneNumber);
    }

    @Step
    public void fillEmailField(String email){
        checkoutPage.setEmailField(email);
    }

    @Step
    public void clickPlaceOrderButton(){
        checkoutPage.clickPlaceOrderButton();
    }

    @Step
    public void assertOrderIsReceived(){
        checkoutPage.assertOrderReceived();
    }
}
