package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

public class AdminProductsPage extends BasePage{
    @FindBy(css = ".wrap  > :nth-child(2)")
    private WebElementFacade addNewProductButton;

    @FindBy(id = "title")
    private WebElementFacade productNameTextBox;

    @FindBy(id = "content")
    private WebElementFacade productDescriptionTextBox;

    @FindBy(id = "publish")
    private WebElementFacade publishProductButton;

    @FindBy(css = ".notice-success a")
    private WebElementFacade viewProductButton;

    @FindBy(css = ".submitdelete.deletion")
    private WebElementFacade moveCreatedItemToTrash;

    @FindBy(id = "message")
    private WebElementFacade displayedMessage;

    public void clickAddNewProductButton(){
        clickOn(addNewProductButton);
    }

    public void clickPublishProductButton(){
        clickOn(publishProductButton);
    }

    public void clickViewProductButton(){
        clickOn(viewProductButton);
    }

    public void clickMoveCreatedItemToTrash(){
        clickOn(moveCreatedItemToTrash);
    }

    public void setProductNameTextBox(String productName){
        typeInto(productNameTextBox, productName);
    }

    public void assertMovedToTrashMessage(){
        Assert.assertTrue(displayedMessage.containsText("moved to the Trash"));
    }
}
