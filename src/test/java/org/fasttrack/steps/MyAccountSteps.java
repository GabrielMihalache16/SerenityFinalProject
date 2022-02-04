package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class MyAccountSteps extends BaseSteps{
    @Step
    public void clickOnLeftAccountDetailsButton(){
        myAccountPage.clickLeftAccountDetailsButton();
    }

    @Step
    public void fillCurrentPasswordField(String password){
        myAccountPage.setCurrentPasswordField(password);
    }

    @Step
    public void fillNewPasswordField(String newPassword){
        myAccountPage.setNewPasswordField(newPassword);
    }

    @Step
    public void fillConfirmNewPasswordField(String confNewPassword){
        myAccountPage.setConfirmNewPasswordField(confNewPassword);
    }

    @Step
    public void clickOnSaveChangesButton(){
        myAccountPage.clickSaveChangesButton();
    }

    @Step
    public void assertPasswordChanged(){
        myAccountPage.assertPasswordIsChanged();
    }

    @Step
    public void firstNameField(){
        myAccountPage.setFirstNameField();
    }

    @Step
    public void lastNameField(){
        myAccountPage.setLastNameField();
    }

    @Step
    public void editCompanyFieldInBillingAddress(){
        myAccountPage.setEditCompanyFieldInBillingAddress();
    }
    
    @Step
    public void editCompanyFieldInShippingAddress(){
        myAccountPage.setEditCompanyFieldInShippingAddress();
    }

    @Step
    public void firstAndLastNameChanged(){
        myAccountPage.assertFirstAndLastNameChanged();
    }

    @Step
    public void clickOnLeftAddressesButton(){
        myAccountPage.clickLeftAddressesButton();
    }

    @Step
    public void clickOnEditBillingAddressButton(){
        myAccountPage.clickEditBillingAddressButton();
    }

    @Step
    public void clickOnclickEditShippingAddressButton(){
        myAccountPage.clickEditShippingAddressButton();
    }

    @Step
    public void clickOnSaveAddressButton(){
        myAccountPage.clickSaveAddressButton();
    }

    @Step
    public void assertCompanyNameIsChangedInBillingAddress(){
        myAccountPage.assertCompanyNameChangedInBillingAddress();
    }

    @Step
    public void assertCompanyNameIsChangedinShippingAddress(){
        myAccountPage.assertCompanyNameChangedInShippingAddress();
    }

    @Step
    public void clickOnLeftOrdersButton(){
        myAccountPage.clickLeftOrdersButton();
    }

    @Step
    public void assertCurrentDateEqualsLastOrderDate(){
        Assert.assertTrue("The date is the current one!",myAccountPage.compareCurrentDateAndLastOrderDate());
    }

}
