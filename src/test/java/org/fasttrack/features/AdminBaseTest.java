package org.fasttrack.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.AdminLoginSteps;
import org.fasttrack.steps.LoginSteps;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import utils.EnvConstants;

@RunWith(SerenityRunner.class)
public class AdminBaseTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximise() {
        driver.manage().window().maximize();
        driver.get(EnvConstants.ADMIN_BASE_URL);
    }

    @Steps
    protected AdminLoginSteps adminLoginSteps;
}
