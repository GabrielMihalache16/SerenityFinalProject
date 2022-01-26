package org.fasttrack.features;

import org.junit.Test;

import static utils.EnvConstants.USER_PASS;

public class MyAccountTest extends BaseTest{
    @Test
    public void changePassword(){
        loginSteps.doLogin();
        myAccountSteps.clickOnLeftAccountDetailsButton();
        myAccountSteps.fillCurrentPasswordField(USER_PASS);
        myAccountSteps.fillNewPasswordField("!Parola123");
        myAccountSteps.fillConfirmNewPasswordField("!Parola123");
        myAccountSteps.clickOnSaveChangesButton();
        myAccountSteps.assertPasswordChanged();
    }
}
