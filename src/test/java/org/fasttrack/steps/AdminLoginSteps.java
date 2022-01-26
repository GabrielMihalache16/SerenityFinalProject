package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;

import static utils.EnvConstants.*;

public class AdminLoginSteps extends AdminBaseSteps{
    @Step
    public void fillInLoginField(String userName){
        adminLoginPage.setLoginField(userName);
    }
    @Step
    public void fillInPasswordField(String pass){
        adminLoginPage.setLoginPasswordField(pass);
    }
    @Step
    public void clickOnLoginButton(){
        adminLoginPage.clickLogInButton();
    }
    @Step
    public void assertLoginIsDone(){
        adminLoginPage.assertLoginDone();
    }

    @Step
    public void doAdminLogin(){
        adminLoginPage.setLoginField(ADMIN_NAME);
        adminLoginPage.setLoginPasswordField(ADMIN_PASS);
        adminLoginPage.clickLogInButton();
    }
}
