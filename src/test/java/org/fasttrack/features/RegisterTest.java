package org.fasttrack.features;

import org.junit.Test;

import static utils.EnvConstants.USER_EMAIL;

public class RegisterTest extends BaseTest{
    @Test
    public void randomCompleteRegisterTest(){
        baseSteps.navigateToHomePage();
        loginSteps.navigateToLoginPage();
        registerSteps.fillRandomnlyRegisterEmail();
        registerSteps.fillRandomnlyRegisterPassword();
        registerSteps.clickRegisterButton();
        registerSteps.assertRegisterDone();
    }

    @Test
    public void veryWeakPasswordRegisterTest(){
        baseSteps.navigateToHomePage();
        loginSteps.navigateToLoginPage();
        registerSteps.fillRandomnlyRegisterEmail();
        registerSteps.fillRegisterPassword("a");
        registerSteps.assertVeryWeakRegisterPassword();
    }
    @Test
    public void weakPasswordRegisterTest(){
        baseSteps.navigateToHomePage();
        loginSteps.navigateToLoginPage();
        registerSteps.fillRandomnlyRegisterEmail();
        registerSteps.fillRegisterPassword("asdfghjeul1");
        registerSteps.assertWeakRegisterPassword();
    }
    @Test
    public void usedEmailRegisterTest(){
        baseSteps.navigateToHomePage();
        loginSteps.navigateToLoginPage();
        registerSteps.fillRegisterEmail(USER_EMAIL);
        registerSteps.fillRegisterPassword("asdfghjeul1535gfsr435");
        registerSteps.clickRegisterButton();
        registerSteps.assertRegisterUsedUsername();
    }
}
