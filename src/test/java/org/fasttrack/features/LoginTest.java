package org.fasttrack.features;


import org.junit.Test;

import static utils.EnvConstants.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentialsTest(){
        baseSteps.navigateToHomePage();
        loginSteps.navigateToLoginPage();
        loginSteps.fillEmailField(USER_EMAIL);
        loginSteps.fillPasswordField(USER_PASS);
        loginSteps.clickOnLoginButton();
        loginSteps.assertLoginDone();
    }

    @Test
    public void loginWithInvalidUsernameTest(){
        baseSteps.navigateToHomePage();
        loginSteps.navigateToLoginPage();
        loginSteps.fillEmailField("dasdasda1230834");
        loginSteps.fillPasswordField(USER_PASS);
        loginSteps.clickOnLoginButton();
        loginSteps.assertLoginWithInvalidUsername();
    }
    @Test
    public void loginWithInvalidEmailTest(){
        baseSteps.navigateToHomePage();
        loginSteps.navigateToLoginPage();
        loginSteps.fillEmailField("asd@asd.asd");
        loginSteps.fillPasswordField(USER_PASS);
        loginSteps.clickOnLoginButton();
        loginSteps.assertLoginInvalidEmail();
    }

    @Test
    public void loginWithNoPasswordTest(){
        baseSteps.navigateToHomePage();
        loginSteps.navigateToLoginPage();
        loginSteps.fillEmailField("dasdasda1230834");
        loginSteps.fillPasswordField("");
        loginSteps.clickOnLoginButton();
        loginSteps.assertLoginNoPassword();
    }
    @Test
    public void loginWithNoUsernameTest(){
        baseSteps.navigateToHomePage();
        loginSteps.navigateToLoginPage();
        loginSteps.fillEmailField("");
        loginSteps.fillPasswordField("a");
        loginSteps.clickOnLoginButton();
        loginSteps.assertLoginNoUsername();
    }

    @Test
    public void logoutTest(){
        baseSteps.navigateToHomePage();
        loginSteps.navigateToLoginPage();
        loginSteps.fillEmailField(USER_EMAIL);
        loginSteps.fillPasswordField(USER_PASS);
        loginSteps.clickOnLoginButton();
        loginSteps.clickOnLeftLogoutButton();
        loginSteps.assertLogoutIsDone();
    }
}
