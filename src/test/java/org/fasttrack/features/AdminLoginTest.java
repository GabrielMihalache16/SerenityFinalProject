package org.fasttrack.features;

import org.junit.Test;

import static utils.EnvConstants.ADMIN_NAME;
import static utils.EnvConstants.ADMIN_PASS;

public class AdminLoginTest extends AdminBaseTest{
    @Test
    public void adminLogin(){
        adminLoginSteps.fillInLoginField(ADMIN_NAME);
        adminLoginSteps.fillInPasswordField(ADMIN_PASS);
        adminLoginSteps.clickOnLoginButton();
        adminLoginSteps.assertLoginIsDone();

    }
}
