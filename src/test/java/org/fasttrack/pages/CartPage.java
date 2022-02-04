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

    @FindBy (css = ".quantity input")
    private List<WebElementFacade> quantityOfProductsInCartList;

    @FindBy (css = ".checkout-button")
    private WebElementFacade proceedToCheckoutButton;

    @FindBy (css = ".cart_item:first-child .product-remove a")
    private WebElementFacade removeItemFromCart;

    @FindBy (css = ".woocommerce-cart-form__cart-item.cart_item:first-child .quantity input")
    private WebElementFacade firstItemInCartQuantity;

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

    @FindBy(css = ".restore-item")
    private WebElementFacade undoButton;

    @FindBy(css = "[name='update_cart']")
    private WebElementFacade updateCartButton;

    @FindBy(css = ".cart-item-number")
    private WebElementFacade quantityOfTopCartButton;

    @FindBy(css = ".return-to-shop a")
    private WebElementFacade returnToShopButton;

    @FindBy(id = "coupon_code")
    private WebElementFacade couponCodeField;

    @FindBy (name = "apply_coupon")
    private WebElementFacade applyCouponButton;

    @FindBy (css = "[data-title*='Coupon']")
    private WebElementFacade couponValue;

    @FindBy (css = ".woocommerce-error")
    private WebElementFacade displayedErrorMessage;

    @FindBy (css = ".woocommerce-message")
    private WebElementFacade displayedMessage;

    @FindBy (css = ".cart-discount")
    private WebElementFacade couponLineInCartTotals;


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
        waitABit(3000);
        return getSubtotalPriceWithTaxes() == getIntFromPrice(grandTotal.getText());
    }

    public boolean isGrandTotalPriceCorrectWithSetPriceCoupon(){
        waitABit(3000);
        return getSubtotalPriceWithTaxes() - getIntFromPrice(couponValue.getText()) == getIntFromPrice(grandTotal.getText());
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

    public void clickReturnToShop(){
        clickOn(returnToShopButton);
    }

    public void removeAllItemsFromCart(){
        if (removeItemFromCart.isPresent() == false){
            shoppingCartEmpty();
        }
        else do{
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

    public void editFirstItemInCartQuantity(String quantityValue){
        typeInto(firstItemInCartQuantity, quantityValue);
    }

    public void clickOnUpdateCartButton(){
        clickOn(updateCartButton);
    }

    public int checkQuantityOfCart(){
        int sum = 0;
        for (WebElementFacade element : quantityOfProductsInCartList) {
            sum += getIntFromPrice(element.getValue());
        }
        return sum;
    }

    public boolean isCartQuantityEqualToCartButtonQuantity(){
        return checkQuantityOfCart() == getIntFromPrice(quantityOfTopCartButton.getText());
    }

    public void checkQuantityOfItemUpdated(int value){
        waitFor(firstItemInCartQuantity);
        Assert.assertTrue(value == getIntFromPrice(firstItemInCartQuantity.getValue()));
    }

    public boolean checkCartDifferentItemsNumber(int expectedItemsNumber){
        return cartProductsList.size() == expectedItemsNumber;
    }

    public void assertFirstItemInCartIsPresent(){
        Assert.assertTrue(firstItemInCartQuantity.isPresent());
    }

    public void setCouponCodeFieldBySetAmountCode(String couponCode){
        waitFor(couponCodeField);
        try {
            typeInto(couponCodeField, couponCode);
        }
        catch (org.openqa.selenium.StaleElementReferenceException exception){
            typeInto(couponCodeField, couponCode);
        }
        catch (org.openqa.selenium.ElementNotVisibleException e){
            typeInto(couponCodeField, couponCode);
        }
        catch (org.openqa.selenium.ElementNotInteractableException e){
            typeInto(couponCodeField, couponCode);
        }
    }

    public void clickApplyCouponButton(){
        clickOn(applyCouponButton);
    }

    public void assertDisplayedMessageCouponAlreadyApplied(){
        Assert.assertEquals("Coupon code already applied!",displayedErrorMessage.getText());
    }

    public void assertDisplayedMessageCouponSuccesfullyApplied(){
        Assert.assertEquals("Coupon code applied successfully.",displayedMessage.getText());
    }

    public void assertDisplayedMessageNoCouponApplied(){
        Assert.assertEquals("Please enter a coupon code.",displayedErrorMessage.getText());
        Assert.assertFalse(couponLineInCartTotals.isPresent());
    }




}
