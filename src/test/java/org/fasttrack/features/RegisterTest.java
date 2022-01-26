package org.fasttrack.features;

import org.junit.Test;

import static utils.EnvConstants.USER_EMAIL;

public class RegisterTest extends BaseTest{
    @Test
    public void randomCompleteRegisterTest(){
        loginSteps.navigateToLoginPage();
        registerSteps.fillRandomnlyRegisterEmail();
        registerSteps.fillRandomnlyRegisterPassword();
        registerSteps.clickRegisterButton();
        registerSteps.assertRegisterDone();
    }

    @Test
    public void veryWeakPasswordRegisterTest(){
        loginSteps.navigateToLoginPage();
        registerSteps.fillRandomnlyRegisterEmail();
        registerSteps.fillRegisterPassword("a");
        registerSteps.assertVeryWeakRegisterPassword();
    }
    @Test
    public void weakPasswordRegisterTest(){
        loginSteps.navigateToLoginPage();
        registerSteps.fillRandomnlyRegisterEmail();
        registerSteps.fillRegisterPassword("asdfghjeul1");
        registerSteps.assertWeakRegisterPassword();
    }
    @Test
    public void usedEmailRegisterTest(){
        loginSteps.navigateToLoginPage();
        registerSteps.fillRegisterEmail(USER_EMAIL);
        registerSteps.fillRegisterPassword("asdfghjeul1535gfsr435");
        registerSteps.clickRegisterButton();
        registerSteps.assertRegisterUsedUsername();
    }
}
