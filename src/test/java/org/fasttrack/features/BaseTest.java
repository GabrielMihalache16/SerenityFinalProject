package org.fasttrack.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import utils.EnvConstants;

@RunWith(SerenityRunner.class)
public class BaseTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximise() {
        driver.manage().window().maximize();
    }

    @Steps
    protected LoginSteps loginSteps;

    @Steps
    protected RegisterSteps registerSteps;

    @Steps
    protected AdminProductSteps adminProductSteps;

    @Steps
    protected AdminLoginSteps adminLoginSteps;

    @Steps
    protected SearchSteps searchSteps;

    @Steps
    protected CartSteps cartSteps;

    @Steps
    protected CheckoutSteps checkoutSteps;

    @Steps
    protected ReviewSteps reviewSteps;

    @Steps
    protected MyAccountSteps myAccountSteps;

    @Steps
    protected BaseSteps baseSteps;

    @Steps
    protected ProductSteps productSteps;

}
