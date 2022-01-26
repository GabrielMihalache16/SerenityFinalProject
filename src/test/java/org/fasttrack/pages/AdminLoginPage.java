package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

public class AdminLoginPage extends AdminBasePage{
    @FindBy(id = "user_login")
    private WebElementFacade loginField;

    @FindBy(id = "user_pass")
    private WebElementFacade passField;

    @FindBy(id = "wp-submit")
    private WebElementFacade logInButton;

    @FindBy(css = ".welcome-panel-content h2")
    private WebElementFacade loginWelcomeText;

    public void setLoginField(String userName){
        typeInto(loginField, userName);
    }
    public void setLoginPasswordField(String pass){
        typeInto(passField, pass);
    }
    public void clickLogInButton(){
        clickOn(logInButton);
    }
    public void assertLoginDone(){
        waitFor(loginWelcomeText);
        Assert.assertEquals("Welcome to WordPress!", loginWelcomeText.getText());
    }
}
