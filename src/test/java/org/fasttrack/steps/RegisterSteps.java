package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;

public class RegisterSteps extends BaseSteps{
    @Step
    public void fillRandomnlyRegisterEmail(){
        loginPage.setRegisterEmailField();
    }

    @Step
    public void fillRandomnlyRegisterPassword(){
        loginPage.setPasswordRegisterField();
    }

    @Step
    public void clickRegisterButton(){
        loginPage.clickRegisterButton();
    }

    @Step
    public void assertRegisterDone(){
        myAccountPage.isHelloMessagePresent();
    }

    @Step
    public void fillRegisterEmail(String email){
        loginPage.setKnownEmailRegisterField(email);
    }

    @Step
    public void fillRegisterPassword(String pass){
        loginPage.setKnownPasswordRegisterField(pass);
    }

    @Step
    public void assertVeryWeakRegisterPassword(){
        loginPage.assertVeryWeakRegisterPassword();
    }

    @Step
    public void assertWeakRegisterPassword(){
        loginPage.assertWeakRegisterPassword();
    }

    @Step
    public void assertRegisterUsedUsername(){
        loginPage.assertRegisterWithUsedUsername();
    }
}
