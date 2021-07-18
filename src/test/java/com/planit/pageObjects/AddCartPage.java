package com.planit.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.planit.Base.BaseClass;
import com.planit.commonMethods.CommonMethods;

import junit.framework.Assert;

public class AddCartPage {

	WebDriver ldriver;

	public AddCartPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@class='overview']//div[@class='product-price']//span")
	WebElement price;
	@FindBy(xpath = "//div[@class='overview']//div[@class='add-to-cart-panel']//input[@class='qty-input']")
	WebElement quantity;
	@FindBy(xpath = "//div[@class='overview']//div[@class='add-to-cart-panel']//input[@type='button']")
	WebElement addToCart;
	@FindBy(xpath = "//p[text()='The product has been added to your ']")
	WebElement sucessMessage;
	@FindBy(xpath = "//table[@class='cart-total']//tr/td/span")
	List<WebElement> SubTotal;
	@FindBy(xpath = "//input[@id='termsofservice']")
	WebElement termsAndCondition;
	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkout;
	@FindBy(xpath = "//select[@id='billing-address-select']")
	WebElement billingAdress;
	@FindBy(xpath = "//div[@id='billing-buttons-container']/input")
	WebElement billingAdressContiune;
	@FindBy(xpath = "//span[@id='shipping-please-wait']/..//input")
	WebElement shippingAdressContiune;
	@FindBy(xpath = "//span[@id='shipping-method-please-wait']/..//input")
	WebElement shippingMethodContiune;
	@FindBy(xpath = "//span[@id='payment-method-please-wait']/..//input")
	WebElement PaymentMethodContiune;
	@FindBy(xpath = "//span[@id='payment-info-please-wait']/..//input")
	WebElement Contiune;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement orderConfromContinue;
	@FindBy(xpath = "//select[@id='shipping-address-select']")
	WebElement shippingAdress;
	@FindBy(xpath = "//label[contains(text(),'Next Day Air')]")
	WebElement nextDayAir;
	@FindBy(xpath = "//p[text()='You will pay by COD']")
	WebElement CODMessage;
	@FindBy(xpath = "//label[contains(text(),'Cash On Delivery (COD)')]")
	WebElement COD;
	@FindBy(xpath = "//span[@id='confirm-order-please-wait']/..//input")
	WebElement confromOrder;
	@FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")
	WebElement orderSucessfullyProceed;
	@FindBy(xpath = "//ul[@class='details']/li")
	WebElement orderNumber;

	/*
	 * @Description : This method get the price
	 * 
	 * @Return : price value
	 * 
	 */

	public int getPrice() {

		return (int) Float.parseFloat(price.getText());

	}

	/*
	 * @Description : This method enter the quantity of the product
	 * 
	 * @Return : void
	 * 
	 */

	public void enterQuantity(String value) {
		quantity.clear();
		quantity.sendKeys(value);

	}

	/*
	 * @Description : This method click add to cart button
	 * 
	 * @Return : void
	 * 
	 */

	public void addToCart() {
		CommonMethods.elementToBeClickableWithWebElement(20, addToCart, ldriver);
		addToCart.click();

	}

	/*
	 * @Description : This method validate the success message is display
	 * 
	 * @Return : void
	 * 
	 */

	public void sucessMessage() {

		Assert.assertTrue(sucessMessage.isDisplayed());
	}

	/*
	 * @Description : This method get sub total value
	 * 
	 * @Return : sub total value
	 * 
	 */

	public int subTotal(String value) {
		return CommonMethods.selectNGetIndexByText(SubTotal, value, false, ldriver);
	}

	/*
	 * @Description : This method validate the sub total value
	 * 
	 * @Return : void
	 * 
	 */

	public void validateSubTotal(int value, String values, String text) {
		int index = subTotal(text);
		WebElement subtotal = ldriver.findElement(
				By.xpath("//table[@class='cart-total']//tr['" + index + "']/td//span[@class='product-price']"));
		Assert.assertEquals(value * Integer.parseInt(values), (int) Float.parseFloat(subtotal.getText()));

	}

	/*
	 * @Description : This method click on the terms and conditions
	 * 
	 * @Return : void
	 * 
	 */

	public void clickOnTermsAndConditions() {
		termsAndCondition.click();
	}

	/*
	 * @Description : This method click on the check out
	 * 
	 * @Return : void
	 * 
	 */

	public void clickOnCheckOut() {
		checkout.click();
	}

	/*
	 * @Description : This method select the billing address from drop down
	 * 
	 * @Return : void
	 * 
	 */

	public void selectBillingAdress(String text) {
		CommonMethods.SelectedDropDownValue(billingAdress, text);
	}

	/*
	 * @Description : This method select shipping adress from drop down
	 * 
	 * @Return : void
	 * 
	 */

	public void selectShippingAdress(String text) {
		CommonMethods.SelectedDropDownValue(shippingAdress, text);
	}

	/*
	 * @Description : This method click shipping method
	 * 
	 * @Return : void
	 * 
	 */

	public void clickShippingMethod() {
		nextDayAir.click();
	}

	/*
	 * @Description : This method click on COD
	 * 
	 * @Return : void
	 * 
	 */

	public void clickCOD() {
		COD.click();
	}

	/*
	 * @Description : This method validate the COD message
	 * 
	 * @Return : void
	 * 
	 */

	public void validateCODMessage() {

		Assert.assertTrue(CODMessage.isDisplayed());
	}

	/*
	 * @Description : This method click on the conform order
	 * 
	 * @Return : void
	 * 
	 */

	public void clickOnConfromOrder() {

		confromOrder.click();
	}

	/*
	 * @Description : This method print the order in log
	 * 
	 * @Return : void
	 * 
	 */

	public void printOrder() {
		BaseClass.logger.info(orderNumber.getText());
	}

	/*
	 * @Description : This method click on the continue button at billing address
	 * 
	 * @Return : void
	 * 
	 */

	public void clickOnContinueAtBillingAdress() {
		billingAdressContiune.click();
	}

	/*
	 * @Description : This method click on the continue button at shipping address
	 * 
	 * @Return : void
	 * 
	 */

	public void clickOnContinueAtShippingAdress() {
		shippingAdressContiune.click();
	}

	/*
	 * @Description : This method click on the continue button at shipping method
	 * 
	 * @Return : void
	 * 
	 */

	public void clickOnContinueAtShippingMethod() {
		shippingMethodContiune.click();
	}

	/*
	 * @Description : This method click on the continue button at COD
	 * 
	 * @Return : void
	 * 
	 */

	public void clickOnContinueAtCOD() {
		PaymentMethodContiune.click();
	}

	/*
	 * @Description : This method click on the continue button
	 * 
	 * @Return : void
	 * 
	 */

	public void clickOnContinueAt() {
		Contiune.click();
	}

	/*
	 * @Description : This method click on the continue button at conform order
	 * 
	 * @Return : void
	 * 
	 */

	public void clickOnContinueAtConfromOrder() {
		orderConfromContinue.click();
	}

	/*
	 * @Description : This method validate the order success message
	 * 
	 * @Return : void
	 * 
	 */

	public void validateOrderSucessMessage() {

		Assert.assertTrue(orderSucessfullyProceed.isDisplayed());
	}

}
