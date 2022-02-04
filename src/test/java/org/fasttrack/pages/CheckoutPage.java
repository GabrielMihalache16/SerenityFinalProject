package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
    @FindBy (id = "billing_first_name")
    private WebElementFacade checkoutFirstNameField;

    @FindBy (id = "billing_last_name")
    private WebElementFacade checkoutLastNameField;

    @FindBy (id = "billing_company")
    private WebElementFacade checkoutCompanyNameField;

    @FindBy (id = "billing_address_1")
    private WebElementFacade checkoutStreetAddressField;

    @FindBy (id = "billing_city")
    private WebElementFacade checkoutCityField;

    @FindBy (id = "billing_state")
    private WebElementFacade checkoutCountySelect;

    @FindBy (id = "billing_postcode")
    private WebElementFacade checkoutPostcodeField;

    @FindBy (id = "billing_phone")
    private WebElementFacade checkoutPhoneField;

    @FindBy (id = "place_order")
    private WebElementFacade placeOrderButton;

    @FindBy (css = ".woocommerce-notice--success")
    private WebElementFacade orderReceivedText;

    @FindBy (id = "billing_email")
    private WebElementFacade emailField;

    public void setCheckoutFirstNameField(String firstName){
        typeInto(checkoutFirstNameField, firstName);
    }

    public void setCheckoutLastNameField(String lastName){
        typeInto(checkoutLastNameField, lastName);
    }

    public void setCheckoutCompanyNameField(String companyName){
        typeInto(checkoutCompanyNameField, companyName);
    }

    public void setCheckoutStreetAddressField(String streetAddress){
        typeInto(checkoutStreetAddressField, streetAddress);
    }

    public void setCheckoutCityField(String city){
        typeInto(checkoutCityField, city);
    }

    public void selectCheckoutCountySelect(String cityInitials){
        Select county = new Select(checkoutCountySelect);
        county.selectByValue(cityInitials);
    }

    public void setCheckoutPostcodeField(String postcode){
        typeInto(checkoutPostcodeField, postcode);
    }

    public void setCheckoutPhoneField(String phoneNumber){
        typeInto(checkoutPhoneField, phoneNumber);
    }

    public void setEmailField(String email){
        typeInto(emailField, email);
    }

    public void clickPlaceOrderButton(){
        clickOn(placeOrderButton);
    }

    public void assertOrderReceived(){
        waitFor(orderReceivedText);
        String expected = "Thank you. Your order has been received.";
        String actual = orderReceivedText.getText();
        Assert.assertEquals(expected,actual);
    }
}
