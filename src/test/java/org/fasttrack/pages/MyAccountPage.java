package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import static utils.EnvConstants.USER_NAME;
import static utils.EnvConstants.USER_PASS;

public class MyAccountPage extends BasePage{
    @FindBy(css = ".woocommerce-MyAccount-content p:first-child")
    private WebElementFacade helloMessage;

    @FindBy(css = ".woocommerce-MyAccount-navigation li:last-child a")
    private WebElementFacade leftLogoutButton;

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
    public void clickLeftAccountDetailsButton(){
        clickOn(leftAccountDetailsButton);
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
}
