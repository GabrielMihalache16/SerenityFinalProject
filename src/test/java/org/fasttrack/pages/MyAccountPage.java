package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static utils.EnvConstants.USER_NAME;

public class MyAccountPage extends BasePage{

    @FindBy(css = ".woocommerce-MyAccount-content p:first-child")
    private WebElementFacade helloMessage;

    @FindBy(css = ".woocommerce-MyAccount-navigation li:last-child a")
    private WebElementFacade leftLogoutButton;

    @FindBy(css = ".woocommerce-MyAccount-navigation li:nth-child(2) a")
    private WebElementFacade leftOrdersButton;

    @FindBy(css = ".order:nth-child(1) time")
    private WebElementFacade lastOrderDate;

    @FindBy(css = ".woocommerce-MyAccount-navigation li:nth-child(4) a")
    private WebElementFacade leftAddressesButton;

    @FindBy(css = ".woocommerce-MyAccount-navigation li:nth-child(5) a")
    private WebElementFacade leftAccountDetailsButton;

    @FindBy(id = "password_current")
    private WebElementFacade currentPasswordField;

    @FindBy(id = "password_1")
    private WebElementFacade newPasswordField;

    @FindBy(id = "password_2")
    private WebElementFacade confirmNewPasswordField;

    @FindBy(css = ".woocommerce-Button")
    private WebElementFacade saveChangesButton;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade passwordChangedSuccessfully;

    @FindBy(id = "account_first_name")
    private WebElementFacade firstNameField;

    @FindBy(id = "account_last_name")
    private WebElementFacade lastNameField;

    @FindBy(css = ".col-1 .edit")
    private WebElementFacade editBillingAddressButton;

    @FindBy(css = ".woocommerce-address-fields .button")
    private WebElementFacade saveAddressButton;

    @FindBy(css = ".col-1 address")
    private WebElementFacade secondRowInBillingAddress;

    @FindBy(css = ".col-2 address")
    private WebElementFacade secondRowInShippingAddress;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade displayedMessage;

    @FindBy(id = "billing_company")
    private WebElementFacade editCompanyFieldInBillingAddress;

    @FindBy(id = "shipping_company")
    private WebElementFacade editCompanyFieldInShippingAddress;

    @FindBy(css = ".col-2 .edit")
    private WebElementFacade editShippingAddress;

    public boolean isHelloMessagePresent(){
        if(helloMessage.isPresent()){
            return true;
        }
        else return false;
    }

    public void assertCorrectHelloMessage(){
        String actual = "Hello " + USER_NAME + " (not " + USER_NAME + "? Log out)";
        Assert.assertEquals(helloMessage.getText(), actual);
    }

    public void clickLeftLogoutButton(){
        clickOn(leftLogoutButton);
    }

    public void clickLeftOrdersButton(){
        clickOn(leftOrdersButton);
    }

    public String getOrderDateReformatted(){
        return getDateFromOrder(lastOrderDate);
    }

    public boolean compareCurrentDateAndLastOrderDate(){
        return getOrderDateReformatted().equals(getCurrentDateWithOrderFormat());
    }

    public void clickLeftAccountDetailsButton(){
        clickOn(leftAccountDetailsButton);
    }

    public void clickLeftAddressesButton(){
        clickOn(leftAddressesButton);
    }

    public void clickEditBillingAddressButton(){
        clickOn(editBillingAddressButton);
    }

    public void clickEditShippingAddressButton(){
        clickOn(editShippingAddress);
    }

    public void clickSaveAddressButton(){
        clickOn(saveAddressButton);
    }

    public void setCurrentPasswordField(String currentPassword){
        typeInto(currentPasswordField, currentPassword);
    }

    public void setNewPasswordField(String newPassword){
        typeInto(newPasswordField, newPassword);
    }

    public void setConfirmNewPasswordField(String confNewPassword){
        typeInto(confirmNewPasswordField, confNewPassword);
    }

    public void clickSaveChangesButton(){
        clickOn(saveChangesButton);
    }

    public void assertPasswordIsChanged(){
        clickOn(passwordChangedSuccessfully);
    }

    public void setFirstNameField() {
        typeInto(firstNameField, getRandomString1());
    }

    public void setLastNameField() {
        typeInto(lastNameField, getRandomString2());
    }

    public void setEditCompanyFieldInBillingAddress() {
        typeInto(editCompanyFieldInBillingAddress, getRandomString1());
    }

    public void setEditCompanyFieldInShippingAddress() {
        typeInto(editCompanyFieldInShippingAddress, getRandomString1());
    }

    public void assertCompanyNameChangedInBillingAddress(){
        waitFor(secondRowInBillingAddress);
        Assert.assertTrue(secondRowInBillingAddress.getText().contains(getRandomString1()));
        Assert.assertEquals("Address changed successfully.", displayedMessage.getText());
    }

    public void assertCompanyNameChangedInShippingAddress(){
        waitFor(secondRowInShippingAddress);
        Assert.assertTrue(secondRowInShippingAddress.getText().contains(getRandomString1()));
        Assert.assertEquals("Address changed successfully.", displayedMessage.getText());
    }

    public void assertFirstAndLastNameChanged(){
        Assert.assertEquals(getRandomString1(), firstNameField.getValue());
        Assert.assertEquals(getRandomString2(), lastNameField.getValue());
    }
}
