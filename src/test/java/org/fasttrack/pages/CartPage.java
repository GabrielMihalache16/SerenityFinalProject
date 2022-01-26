package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CartPage extends BasePage{
    WebDriver driver;
    @FindBy (css = "td.product-name a")
    private List<WebElementFacade> cartProductsList;

    @FindBy (css = ".checkout-button")
    private WebElementFacade proceedToCheckoutButton;

    @FindBy (css = ".cart_item:first-child .product-remove a")
    private WebElementFacade removeItemFromCart;

    @FindBy(css = "td.product-price .amount")
    private List<WebElementFacade> listOfSubtotalPrices;

    @FindBy(css = "[data-title=\"Subtotal\"] .amount")
    private WebElementFacade subtotalText;

    @FindBy(css = ".shipping .amount")
    private WebElementFacade shippingFeeText;

    @FindBy(css = ".order-total .amount")
    private WebElementFacade grandTotal;

    @FindBy(css = ".cart-empty")
    private WebElementFacade emptyCartText;

    @FindBy(css = ".fa-shopping-cart")
    private WebElementFacade cartButton;

    @FindBy(css = ".restore-item")
    private WebElementFacade undoButton;


    public boolean isLastItemAdded(String item){
        for (WebElementFacade element : cartProductsList){
            if (cartProductsList.get(cartProductsList.size()-1).getText().contains(item)){
                return true;
            }
        }
        return false;
    }

    public int getSubtotalPricesCalculated() {
        int sum = 0;
        for (WebElementFacade element : listOfSubtotalPrices) {
            sum += getIntFromPrice(element.getText());
        }
        return sum;
    }

    public boolean isSubtotalPriceCorrect() {
        return getSubtotalPricesCalculated() == getIntFromPrice(subtotalText.getText());
    }

    public int getSubtotalPriceWithTaxes(){
        String x = subtotalText.getText();
        String y = shippingFeeText.getText();
        return getIntFromPrice(x) + getIntFromPrice(y);
    }

    public boolean isGrandTotalPriceCorrect(){
        return getSubtotalPriceWithTaxes() == getIntFromPrice(grandTotal.getText());
    }

    public void clickProceedToCheckoutButton(){
        clickOn(proceedToCheckoutButton);
    }
    public void removeItem(){
        clickOn(removeItemFromCart);
    }
    public void clickUndoButton(){
        clickOn(undoButton);
    }
    public void removeAllItemsFromCart(){
        do{
            try {
                removeItem();
            }
            catch(org.openqa.selenium.StaleElementReferenceException ex) {
                removeItem();
            }
        }while(emptyCartText.isPresent() == false);
    }

    public void shoppingCartEmpty(){
        Assert.assertEquals("Your cart is currently empty.",emptyCartText.getText());
    }

    public boolean isUndoButtonCorrect(){
        int a = cartProductsList.size();
        removeItem();
        clickUndoButton();
        if (a == cartProductsList.size()){
            return true;
        }
        return false;
    }

}
