package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;

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
}
