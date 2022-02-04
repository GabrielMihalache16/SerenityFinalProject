package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;

import static utils.EnvConstants.*;

public class LoginSteps extends BaseSteps{


    @Step
    public void navigateToLoginPage(){
        homePage.clickAccountPage();
    }

    @Step
    public void fillEmailField(String email){
        loginPage.setLoginEmailField(email);

    }

    @Step
    public void fillPasswordField(String pass){
        loginPage.setLoginPasswordField(pass);

    }

    @Step
    public void clickOnLoginButton(){
        loginPage.clickLoginButton();

    }
    @Step
    public void clickOnLeftLogoutButton(){
        myAccountPage.clickLeftLogoutButton();
    }

    @Step
    public void doLogin(){
        homePage.clickAccountPage();
        loginPage.setLoginEmailField(USER_EMAIL);
        loginPage.setLoginPasswordField(USER_PASS);
        loginPage.clickLoginButton();
    }

    @Step
    public void doLogOut(){
        homePage.clickAccountPage();
        myAccountPage.clickLeftLogoutButton();
    }

    @Step
    public void assertLoginDone(){
        myAccountPage.isHelloMessagePresent();
        myAccountPage.assertCorrectHelloMessage();
    }

    @Step
    public void assertLogoutIsDone(){
        loginPage.assertLogoutDone();
    }

    @Step
    public void assertLoginWithInvalidUsername(){
        loginPage.assertLoginWithInvalidUsername();
    }

    @Step
    public void assertLoginNoPassword(){
        loginPage.assertLoginWithNoPassword();
    }

    @Step
    public void assertLoginNoUsername(){
        loginPage.assertLoginWithNoUsername();
    }

    @Step
    public void assertLoginInvalidEmail(){
        loginPage.assertLoginWithInvalidEmail();
    }
}
