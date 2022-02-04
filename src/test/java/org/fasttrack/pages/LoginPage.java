package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;


public class LoginPage extends BasePage{

    @FindBy(id = "username")
    private WebElementFacade emailLoginField;

    @FindBy(id = "password")
    private WebElementFacade passwordLoginField;

    @FindBy(name = "login")
    private WebElementFacade loginButton;

    @FindBy(id = "reg_email")
    private WebElementFacade emailRegisterField;

    @FindBy(id = "reg_password")
    private WebElementFacade passwordRegisterField;

    @FindBy(name = "register")
    private WebElementFacade registerButton;

    @FindBy(css = ".disabled")
    private WebElementFacade disabledRegisterButton;

    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade loginErrorMessage;

    @FindBy(css = ".woocommerce-password-strength")
    private WebElementFacade weakPasswordRegisterMessage;

    public void setLoginEmailField(String email){
        typeInto(emailLoginField, email);
    }

    public void setLoginPasswordField(String pass){
        typeInto(passwordLoginField, pass);
    }

    public void setRegisterEmailField(){
        String randEmail = randomAlphabetic(9, 14);
        typeInto(emailRegisterField, randEmail+"@gmail.com");
        System.out.println("The registered email is: " + randEmail + "@gmail.com");
    }

    public void setPasswordRegisterField(){
        String password = randomAlphabetic(9, 14);
        typeInto(passwordRegisterField, password);
        System.out.println("The registered password is: " + password);
    }

    public void setKnownPasswordRegisterField(String pass){
        typeInto(passwordRegisterField, pass);
    }

    public void setKnownEmailRegisterField(String email){
        typeInto(emailRegisterField, email);
    }

    public void clickLoginButton(){
        clickOn(loginButton);
    }

    public void clickRegisterButton(){
        clickOn(registerButton);
    }

    public void assertLogoutDone(){
        Assert.assertTrue(emailLoginField.isPresent());
    }

    public void assertLoginWithInvalidUsername(){
        Assert.assertTrue(loginErrorMessage.containsText("Invalid username"));
        Assert.assertTrue(emailLoginField.isPresent());
        Assert.assertTrue(passwordLoginField.isPresent());
        Assert.assertTrue(loginButton.isPresent());
    }

    public void assertLoginWithInvalidEmail(){
        Assert.assertTrue(loginErrorMessage.containsText("Invalid email address"));
        Assert.assertTrue(emailLoginField.isPresent());
        Assert.assertTrue(passwordLoginField.isPresent());
        Assert.assertTrue(loginButton.isPresent());
    }

    public void assertLoginWithNoPassword(){
        Assert.assertTrue(loginErrorMessage.containsText("The password field is empty."));
        Assert.assertTrue(emailLoginField.isPresent());
        Assert.assertTrue(passwordLoginField.isPresent());
        Assert.assertTrue(loginButton.isPresent());
    }

    public void assertLoginWithNoUsername(){
        Assert.assertTrue(loginErrorMessage.containsText("Username is required."));
        Assert.assertTrue(emailLoginField.isPresent());
        Assert.assertTrue(passwordLoginField.isPresent());
        Assert.assertTrue(loginButton.isPresent());
    }

    public void assertRegisterWithUsedUsername(){
        Assert.assertTrue(loginErrorMessage.containsText("An account is already registered with your email address"));
        Assert.assertTrue(emailRegisterField.isPresent());
        Assert.assertTrue(passwordRegisterField.isPresent());
        Assert.assertTrue(registerButton.isPresent());
    }

    public void assertVeryWeakRegisterPassword(){
        Assert.assertFalse(disabledRegisterButton.isClickable());
        Assert.assertTrue(weakPasswordRegisterMessage.containsText("Very weak"));
    }

    public void assertWeakRegisterPassword(){
        Assert.assertFalse(disabledRegisterButton.isClickable());
        Assert.assertTrue(weakPasswordRegisterMessage.containsText("Weak"));
    }

}
